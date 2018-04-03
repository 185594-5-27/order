package com.mongodb.sys.entity;

import com.mongodb.common.base.entity.QueryBase;
import org.bson.types.ObjectId;

public class QueryUser extends QueryBase {

    private String userName;

    private String login;

    private String job;

    private ObjectId groupId;

    public String getGroupId() {
        if(groupId==null){
            return "";
        }else{
            return groupId.toString();
        }

    }

    public void setGroupId(String groupId) {
        if(groupId!=null&&!groupId.equals("")){
            this.groupId = new ObjectId(groupId);
        }else{
            this.groupId = null;
        }
    }

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
