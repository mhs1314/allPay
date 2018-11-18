package com.qht.model;

import java.io.Serializable;

public class SelectPkgLevelAllModel implements Serializable {
	/**
	 * 班级id
	 */
	private String uid;
	/**
	 * 班级名称
	 */
	private String class_name;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	

}
