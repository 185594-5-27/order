package com.mongodb.sys.service;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.common.base.entity.Pagination;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.dao.UserDao;
import com.mongodb.sys.entity.QueryUser;
import com.mongodb.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    protected MongodbBaseDao<User,QueryUser> getDao() {
        return userDao;
    }


    /**
     * 功能描述：实现用户的分页逻辑
     * @param entity
     * @return
     */
    public Pagination<User> findByPage(QueryUser entity){
        Query query = new Query();
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
