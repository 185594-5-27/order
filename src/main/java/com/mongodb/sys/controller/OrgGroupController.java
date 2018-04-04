package com.mongodb.sys.controller;

import com.mongodb.common.base.constant.SystemStaticConst;
import com.mongodb.common.base.controller.MongodbBaseController;
import com.mongodb.common.base.entity.Pagination;
import com.mongodb.common.base.service.MongodbBaseService;
import com.mongodb.sys.entity.OrgGroup;
import com.mongodb.sys.entity.QueryOrgGroup;
import com.mongodb.sys.entity.QueryUser;
import com.mongodb.sys.entity.User;
import com.mongodb.sys.service.OrgGroupService;
import com.mongodb.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/*
* 类描述：
* @auther linzf
* @create 2018/4/3 0003 
*/
@Controller
@RequestMapping("/group")
public class OrgGroupController  extends MongodbBaseController<OrgGroup,QueryOrgGroup> {

    @Autowired
    private OrgGroupService orgGroupService;
    @Autowired
    private UserService userService;

    @Override
    protected MongodbBaseService<OrgGroup, QueryOrgGroup> getService() {
        return orgGroupService;
    }


    /**
     * 功能描述：跳转到更新用户的页面
     * @param entity
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateUserPage")
    public String updateUserPage(User entity, Model model) throws Exception {
        entity = userService.get(entity.getId());
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+"/updateUser";
    }

    /**
     * 跳转到添加用户的页面
     * @throws Exception
     * */
    @RequestMapping(value="/addUserPage")
    public String addUserPage() throws Exception{
        return getPageBaseRoot()+"/addUser";
    }

    @RequestMapping(value="/updateGroupPage")
    public String updateGroupPage(OrgGroup entity,Model model) throws Exception {
        entity = orgGroupService.get(entity.getId());
        entity.setOrgGroup(orgGroupService.get(entity.getParentId()));
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+UPDATEPAGE;
    }

    @RequestMapping(value="/addGroupPage")
    public String addPage(OrgGroup entity,Model model) throws Exception {
        entity = orgGroupService.get(entity.getId());
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+ADDPAGE;
    }

    /**
     * 功能描述：获取组织架构底下的相应的用户
     * @return
     */
    @RequestMapping(value = "/userList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> userList(QueryUser entity){
        Map<String,Object> result = new HashMap<String, Object>();
        Pagination page = userService.findByPage(entity);
        result.put("totalCount",page.getTotalNumber());
        result.put("result",page.getItems());
        return result;
    }


    /**
     * 功能描述：获取组织架构的整颗菜单树
     * @return
     */
    @RequestMapping(value = "/loadGroupTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> loadGroupTree(){
        Map<String,Object> result = new HashMap<String, Object>();
        List<OrgGroup> orgGroupList = orgGroupService.find(new Query());
        result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
        result.put(SystemStaticConst.MSG,"加载组织机构数据成功！");
        result.put("data",orgGroupList);
        return result;
    }


}
