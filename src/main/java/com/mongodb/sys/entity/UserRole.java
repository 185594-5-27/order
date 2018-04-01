package com.mongodb.sys.entity;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
* 类描述：
* @auther linzf
* @create 2018/3/30 0030 
*/
public class UserRole {

    public static void main(String [] args){
        UserRole userRole = new UserRole();
        userRole.setId(1);
        userRole.setName("ROLE_ADMIN");
        userRole.setRoleName("system");
        List<Tree> treeList = new ArrayList<Tree>();
        Tree tree = new Tree();
        tree.setId(1l);
        tree.setName("system-manager");
        tree.setParentId(0);
        tree.setCode("system-manager");
        tree.setState("1");
        tree.setTreeOrder(1);
        treeList.add(tree);
        tree = new Tree();
        tree.setId(2l);
        tree.setName("user_manager");
        tree.setParentId(1l);
        tree.setCode("user_manager");
        tree.setState("1");
        tree.setTreeOrder(1);
        tree.setUrl("/userList");
        treeList.add(tree);
        userRole.setTreeList(treeList);
        System.out.println(JSONObject.fromObject(userRole).toString());
    }

    private long id;

    private String name;

    private String roleName;

    private List<Tree> treeList;

    public List<Tree> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<Tree> treeList) {
        this.treeList = treeList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
