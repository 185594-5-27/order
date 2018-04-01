package com.mongodb.sys.entity;

import org.bson.types.ObjectId;

/**
 *@author linzf
 **/
public class Dict {
	private ObjectId id;
	private String code;
	private String text;
	private String type;
	private String value;
	private String isLoad;

	public String getId() {
		return id.toString();
	}

	public void setId(String id) {
		this.id = new ObjectId(id);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsLoad() {
		return isLoad;
	}

	public void setIsLoad(String isLoad) {
		this.isLoad = isLoad;
	}

}
