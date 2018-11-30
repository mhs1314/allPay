package com.qht.dto;

import java.io.Serializable;

public class AppInsertChapterParameter implements Serializable {
	//章节主键
	private String uid;
	//运营商id
	private String tenant_id;
	//章节名称
	private String chapter_name;
	//课程包id
	private String course_id;
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
	
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	
}
