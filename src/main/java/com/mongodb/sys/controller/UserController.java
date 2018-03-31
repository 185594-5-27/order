package com.mongodb.sys.controller;

import com.mongodb.common.base.controller.MongodbBaseController;
import com.mongodb.common.base.entity.Pagination;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.entity.QueryUser;
import com.mongodb.sys.entity.User;
import com.mongodb.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends MongodbBaseController<User,QueryUser> {

    @Autowired
    private UserService userService;

    @Override
    protected MongodbBaseService<User,QueryUser> getService() {
        return userService;
    }

    /**
     * 功能描述：获取数据字典的分页的数据
     * @param entity
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> list(QueryUser entity){
        Map<String,Object> result = new HashMap<String, Object>();
        Pagination page = userService.findByPage(entity);
        result.put("totalCount",page.getTotalNumber());
        result.put("result",page.getItems());
        return result;
    }
}
