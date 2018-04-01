package com.mongodb.sys.controller;

import com.mongodb.common.base.controller.MongodbBaseController;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.entity.QueryUserRole;
import com.mongodb.sys.entity.UserRole;
import com.mongodb.sys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class UserRoleController extends MongodbBaseController<UserRole,QueryUserRole> {

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected MongodbBaseService<UserRole, QueryUserRole> getService() {
        return userRoleService;
    }



}
