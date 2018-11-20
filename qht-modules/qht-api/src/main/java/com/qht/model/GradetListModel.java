package com.qht.model;

import java.io.Serializable;

public class GradetListModel implements Serializable {
	private String uid;
	private String grade_name;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	

}
