package com.mongodb.sys.entity;

import com.mongodb.common.base.entity.QueryBase;

public class QueryUser extends QueryBase {

    private String userName;

    private String login;

    private String job;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
