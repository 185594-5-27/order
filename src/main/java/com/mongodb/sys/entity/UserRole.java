package com.mongodb.sys.entity;

/*
* 类描述：
* @auther linzf
* @create 2018/3/30 0030 
*/
public class UserRole {

    private long id;
    private String name;
    private String roleName;

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
