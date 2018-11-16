package com.qht.dto;

import java.io.Serializable;

public class UidAndTenantID implements Serializable {
	//主键
	private String uid;
	//运营id
	private String tenant_id;
	private String token;

	@Override
	public String toString() {
		return "UidAndTenantID{" +
				"uid='" + uid + '\'' +
				", tenant_id='" + tenant_id + '\'' +
				", token='" + token + '\'' +
				", school_id='" + school_id + '\'' +
				'}';
	}

	public String getSchool_id() {
		return school_id;
	}

	public void setSchool_id(String school_id) {
		this.school_id = school_id;
	}

	private String school_id;
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
	
	

}
