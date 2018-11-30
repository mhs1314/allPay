package com.qht.model;
/**
* @author Zuoxh
* @version 创建时间：2018年11月18日 下午3:25:52
* 类说明
*/

import java.io.Serializable;

public class MyIndexCourseCelcollectParam implements Serializable{
	private String uid;
	
	private String tenant_id;
	
	private String student_id;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "MyIndexCourseCelcollectParam [uid=" + uid + ", tenant_id=" + tenant_id + ", student_id=" + student_id
				+ ", id=" + id + "]";
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

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
}
