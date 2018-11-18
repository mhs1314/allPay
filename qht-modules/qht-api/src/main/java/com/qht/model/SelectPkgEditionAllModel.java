package com.qht.model;

import java.io.Serializable;

public class SelectPkgEditionAllModel implements Serializable {
	//课程包版本
	private String uid;
	//版本名称
	private String name;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
