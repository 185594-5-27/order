package com.mongodb.sys.service;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.common.base.entity.Pagination;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.common.util.user.UserInfo;
import com.mongodb.sys.dao.UserDao;
import com.mongodb.sys.dao.UserRoleDao;
import com.mongodb.sys.entity.QueryUser;
import com.mongodb.sys.entity.User;
import com.mongodb.sys.entity.UserRole;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * 功能描述:实现用户管理的service
 */
@Service
public class UserService extends MongodbBaseService<User,QueryUser> {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    protected MongodbBaseDao<User,QueryUser> getDao() {
        return userDao;
    }

    /**
     * 功能描述：更新用户状态为可用或者不可用
     * @param user
     * @return
     */
    public void userControl(User user){
        userDao.userControl(user);
    }


    @Override
    public void updateById(String id, User user) {
        user.packagingRoles(user.getRoleArray(),userRoleDao);
        super.updateById(id, user);
    }

    @Override
    public User save(User entity) {
        entity.setAddress(entity.getProvince()+entity.getCity()+entity.getDistrict()+entity.getStreetAddress());
        entity.setPassword(UserInfo.encode(entity.getPassword()));
        entity.setState("1");
        entity.packagingRoles(entity.getRoleArray(),userRoleDao);
        return super.save(entity);
    }

    /**
     * 功能描述：实现用户的分页逻辑
     * @param entity
     * @return
     */
    public Pagination<User> findByPage(QueryUser entity){
        Query query = new Query();
        if(entity.getUserName()!=null&&!entity.getUserName().equals("")){
            query.addCriteria(Criteria.where("userName").regex(".*?"+entity.getUserName()+".*"));
        }
        if(entity.getLogin()!=null&&!entity.getLogin().equals("")){
            query.addCriteria(Criteria.where("login").regex(".*?"+entity.getLogin()+".*"));
        }
        if(entity.getJob()!=null&&!entity.getJob().equals("")){
            query.addCriteria(Criteria.where("job").regex(".*?"+entity.getJob()+".*"));
        }
        if(entity.getGroupId()!=null&&!entity.getGroupId().equals("")){
            query.addCriteria(Criteria.where("orgGroup.id").is(new ObjectId(entity.getGroupId())));
        }
        return userDao.findByPage(entity,query);
    }

    /**
     * 功能描述：根据账号来获取用户信息
     * @param login
     * @return
     */
    public User findByLogin(String login){
        return userDao.findByLogin(login);
    }

    @Override
    public void update(Query query, Update update) {
        super.update(query, update);
    }
}
