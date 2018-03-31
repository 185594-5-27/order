package com.mongodb.sys.dao;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/*
* 类描述：实现用户管理的dao
* @auther linzf
* @create 2018/3/30 0030 
*/
@Component
public class UserDao extends MongodbBaseDao<User> {

    /**
     * 功能描述：根据账号来获取用户信息
     * @param login
     * @return
     */
    public User findByLogin(String login){
        Query query=new Query(Criteria.where("login").is(login));
        User user =  mongoTemplate.findOne(query , User.class);
        return user;
    }

}
