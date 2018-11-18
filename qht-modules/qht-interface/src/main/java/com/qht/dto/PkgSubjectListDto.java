package com.qht.dto;

import java.io.Serializable;

public class PkgSubjectListDto implements Serializable {
	private String uid;
	private String subject_name;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	

}
