package com.qht.model;

import java.io.Serializable;

public class SelectCoursePkgPingModel implements Serializable {
	
	private String head;
	private String uid;
	private String comments_time;
	private String pkg_name;
	private String comments_star;
	private String comments_content;
	private String name;
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getComments_time() {
		return comments_time;
	}
	public void setComments_time(String comments_time) {
		this.comments_time = comments_time;
	}
	public String getPkg_name() {
		return pkg_name;
	}
	public void setPkg_name(String pkg_name) {
		this.pkg_name = pkg_name;
	}
	public String getComments_star() {
		return comments_star;
	}
	public void setComments_star(String comments_star) {
		this.comments_star = comments_star;
	}
	public String getComments_content() {
		return comments_content;
	}
	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SelectCoursePkgPingModel [head=" + head + ", uid=" + uid + ", comments_time=" + comments_time
				+ ", pkg_name=" + pkg_name + ", comments_star=" + comments_star + ", comments_content="
				+ comments_content + ", name=" + name + "]";
	}
	

}
