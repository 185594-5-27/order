package com.mongodb.sys.service;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.common.base.entity.Pagination;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.dao.UserDao;
import com.mongodb.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * 功能描述:实现用户管理的service
 */
@Service
public class UserService extends MongodbBaseService<User> {

    @Autowired
    private UserDao userDao;

    @Override
    protected MongodbBaseDao<User> getDao() {
        return userDao;
    }


    /**
     * 功能描述：实现用户的分页逻辑
     * @param currentPage
     * @param pageSize
     * @param entity
     * @return
     */
    public Pagination<User> findByPage(int currentPage, int pageSize,User entity){
        Query query = new Query();
        return userDao.findByPage(currentPage,pageSize,query);
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
