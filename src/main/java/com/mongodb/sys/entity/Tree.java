package com.mongodb.sys.entity;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *@author linzf
 **/
public class Tree implements Comparable<Tree> {


	public static void main(String [] args){
		Tree tree = new Tree();
		tree.setId(1l);
		tree.setName("系统管理");
		tree.setParentId(0);
		tree.setCode("system");
		tree.setState("1");
		tree.setTreeOrder(1);
		System.out.println(JSONObject.fromObject(tree).toString());
		tree = new Tree();
		tree.setId(2l);
		tree.setName("用户管理");
		tree.setParentId(1l);
		tree.setCode("user_manager");
		tree.setState("1");
		tree.setTreeOrder(1);
		tree.setUrl("/userList");
		System.out.println(JSONObject.fromObject(tree).toString());
	}

	public Tree(){
		super();
	}

	public Tree(Long id){
		this.id = id;
	}

	private long id;
	private String code;
	private String icon;
	private String name;
	private long parentId;
	private long treeOrder;
	private String url;
	private String state;
	private List<Tree> child;

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public List<Tree> getChild() {
		return child;
	}

	public void setChild(List<Tree> child) {
		this.child = child;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTreeOrder() {
		return treeOrder;
	}

	public void setTreeOrder(long treeOrder) {
		this.treeOrder = treeOrder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 功能描述：实现集合根据treeOrder字段进行排序的功能
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Tree o) {
		long i = this.getTreeOrder() - o.getTreeOrder();
		return Integer.parseInt(i+"");
	}
}
