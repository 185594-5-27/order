package com.mongodb.sys.entity;

import org.bson.types.ObjectId;

import java.util.List;

/*
* 类描述：
* @auther linzf
* @create 2018/4/2 0002 
*/
public class OrgGroup {

    // 当前节点ID
    private ObjectId id;
    // 部门父节点ID
    private ObjectId parentId;
    // 部门现有人数
    private long existingNum;
    // 节点编码
    private String groupCode;
    // 部门名字
    private String name;
    // 部门配置人数
    private long num;
    // 父部门信息
    private OrgGroup orgGroup;
    // 子部门信息集合
    private List<OrgGroup> children;

    public List<OrgGroup> getChildren() {
        return children;
    }

    public void setChildren(List<OrgGroup> children) {
        this.children = children;
    }

    public String getId() {
        if(id!=null){
            return id.toString();
        }else{
            return "";
        }
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
    }

    public String getParentId() {
        if(parentId!=null){
            return parentId.toString();
        }else{
            return "";
        }
    }

    public void setParentId(String parentId) {
        this.parentId = new ObjectId(parentId);
    }

    public long getExistingNum() {
        return existingNum;
    }

    public void setExistingNum(long existingNum) {
        this.existingNum = existingNum;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public OrgGroup getOrgGroup() {
        return orgGroup;
    }

    public void setOrgGroup(OrgGroup orgGroup) {
        this.orgGroup = orgGroup;
    }
}
