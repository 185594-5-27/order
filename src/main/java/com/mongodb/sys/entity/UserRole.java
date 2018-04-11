package com.mongodb.sys.entity;

import com.mongodb.common.base.entity.QueryField;
import net.sf.json.JSONObject;
import org.bson.types.ObjectId;

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
        userRole.setId(ObjectId.get().toString());
        userRole.setName("ROLE_ADMIN");
        userRole.setRoleName("system");
        List<Tree> treeList = new ArrayList<Tree>();
        ObjectId parentId = ObjectId.get();
        Tree tree = new Tree();
        tree.setId(ObjectId.get().toString());
        tree.setName("system-manager");
        tree.setCode("system-manager");
        tree.setState("1");
        tree.setParentId(parentId.toString());
        tree.setIcon("fa fa-fw fa-cogs");
        tree.setTreeOrder(1);
        treeList.add(tree);
        String mainId = tree.getId();
        tree = new Tree();


        tree.setId(ObjectId.get().toString());
        tree.setName("tree_manager");
        tree.setParentId(mainId);
        tree.setCode("tree_manager");
        tree.setState("1");
        tree.setTreeOrder(1);
        tree.setUrl("treeList");
        tree.setIcon("fa fa-fw fa-tree");
        treeList.add(tree);
        tree = new Tree();

        tree.setId(ObjectId.get().toString());
        tree.setName("group_manager");
        tree.setParentId(mainId);
        tree.setCode("group_manager");
        tree.setState("1");
        tree.setTreeOrder(1);
        tree.setUrl("groupList");
        tree.setIcon("fa fa-fw fa-group");
        treeList.add(tree);


        tree = new Tree();
        tree.setId(ObjectId.get().toString());
        tree.setName("role_manager");
        tree.setParentId(mainId);
        tree.setCode("role_manager");
        tree.setState("1");
        tree.setTreeOrder(1);
        tree.setUrl("userRoleList");
        tree.setIcon("fa fa-fw fa-user-secret");
        treeList.add(tree);

        tree = new Tree();
        tree.setId(ObjectId.get().toString());
        tree.setName("user_manager");
        tree.setParentId(mainId);
        tree.setCode("user_manager");
        tree.setState("1");
        tree.setTreeOrder(1);
        tree.setUrl("userList");
        tree.setIcon("fa fa-fw fa-user");
        treeList.add(tree);

        tree = new Tree();
        tree.setId(ObjectId.get().toString());
        tree.setName("dict_manager");
        tree.setParentId(mainId);
        tree.setCode("dict_manager");
        tree.setState("1");
        tree.setTreeOrder(1);
        tree.setUrl("dictList");
        tree.setIcon("fa fa-fw fa-book");
        treeList.add(tree);

        userRole.setTreeList(treeList);
        System.out.println(JSONObject.fromObject(userRole).toString());
    }

    private ObjectId id;

    // 增加QueryField注解在buildBaseQuery构建Query查询条件的时候会自动将其加入到Query查询条件中
    @QueryField
    private String name;

    private String roleName;

    private List<Tree> treeList;

    // 临时采访菜单数集合的数据
    private String treeArray;

    public String getTreeArray() {
        return treeArray;
    }

    public void setTreeArray(String treeArray) {
        this.treeArray = treeArray;
    }

    public List<Tree> getTreeList() {
        return treeList;
    }

    public void setTreeList(List<Tree> treeList) {
        this.treeList = treeList;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
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

    public void packagingTrees(String treeArray){
        Tree tree = null;
        List<Tree> trees = new ArrayList<>();
        for(String id:treeArray.split(",")){
            if(!id.isEmpty()){
                tree = new Tree(id);
                trees.add(tree);
            }
        }
        this.setTreeList(trees);
    }
}
