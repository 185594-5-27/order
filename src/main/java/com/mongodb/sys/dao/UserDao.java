package com.mongodb.sys.dao;

import com.mongodb.common.base.dao.MongodbBaseDao;
import com.mongodb.sys.entity.QueryUser;
import com.mongodb.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/*
* 类描述：实现用户管理的dao
* @auther linzf
* @create 2018/3/30 0030 
*/
@Component
public class UserDao extends MongodbBaseDao<User,QueryUser> {



    /**
     * 功能描述：根据账号来获取用户信息
     * @param login
     * @return
     */
    public User findByLogin(String login){
        Query query=new Query(Criteria.where("login").is(login));
        printLog(query);
        User user =  mongoTemplate.findOne(query , User.class);
        return user;
    }

    /**
     * 功能描述：更新用户状态为可用或者不可用
     * @param user
     * @return
     */
    public void userControl(User user){
        Query query=new Query(Criteria.where("id").is(user.getId()));
        printLog(query);
        Update update= new Update().set("state", user.getState());
        mongoTemplate.updateFirst(query,update,User.class);
    }

}
