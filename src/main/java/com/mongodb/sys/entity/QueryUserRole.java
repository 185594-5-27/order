package com.mongodb.sys.entity;

import com.mongodb.common.base.entity.QueryBase;
import com.mongodb.common.base.entity.QueryField;
import com.mongodb.common.base.entity.QueryType;

public class QueryUserRole extends QueryBase {

    @QueryField(type = QueryType.LIKE)
    private String name;
    @QueryField(type = QueryType.LIKE)
    private String roleName;

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
