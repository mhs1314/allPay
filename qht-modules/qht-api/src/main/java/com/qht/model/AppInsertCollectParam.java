package com.qht.model;

import java.io.Serializable;

public class AppInsertCollectParam implements Serializable {
	private String uid;
	private String tenant_id;
	private String student_id;
	private String course_pkg_id;
	private String is_collect;
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
	public String getCourse_pkg_id() {
		return course_pkg_id;
	}
	public void setCourse_pkg_id(String course_pkg_id) {
		this.course_pkg_id = course_pkg_id;
	}
	public String getIs_collect() {
		return is_collect;
	}
	public void setIs_collect(String is_collect) {
		this.is_collect = is_collect;
	}
	@Override
	public String toString() {
		return "AppInsertCollectParam [uid=" + uid + ", tenant_id=" + tenant_id + ", student_id=" + student_id
				+ ", course_pkg_id=" + course_pkg_id + ", is_collect=" + is_collect + "]";
	}
	

}
