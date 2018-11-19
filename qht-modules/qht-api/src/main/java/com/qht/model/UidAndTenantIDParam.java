package com.qht.model;

import java.io.Serializable;

public class UidAndTenantIDParam implements Serializable {
	//主键
	private String uid;
	//运营id
	private String tenant_id;
	private String token;
	private String school_id;
	private String teacher_id;
	private String play_type_id;
	
	public String getPlay_type_id() {
		return play_type_id;
	}
	public void setPlay_type_id(String play_type_id) {
		this.play_type_id = play_type_id;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getSchool_id() {
		return school_id;
	}
	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "UidAndTenantIDParam [uid=" + uid + ", tenant_id=" + tenant_id + ", token=" + token + ", school_id="
				+ school_id + ", teacher_id=" + teacher_id + "]";
	}
	
	

}
