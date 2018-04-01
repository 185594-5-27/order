package com.mongodb.sys.controller;

import com.mongodb.common.base.constant.SystemStaticConst;
import com.mongodb.common.base.controller.MongodbBaseController;
import com.mongodb.common.base.entity.Pagination;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.common.util.user.UserInfo;
import com.mongodb.sys.entity.QueryUser;
import com.mongodb.sys.entity.Tree;
import com.mongodb.sys.entity.User;
import com.mongodb.sys.service.UserRoleService;
import com.mongodb.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends MongodbBaseController<User,QueryUser> {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected MongodbBaseService<User,QueryUser> getService() {
        return userService;
    }

    /**
     * 功能描述：加载首页菜单节点的数据
     * @return
     */
    @RequestMapping(value="/mainTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> mainTree(){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Tree> trees = UserInfo.loadUserTree(userRoleService);
        result.put("data",trees);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        return result;
    }


    /**
     * 功能描述：获取用户的分页的数据
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
