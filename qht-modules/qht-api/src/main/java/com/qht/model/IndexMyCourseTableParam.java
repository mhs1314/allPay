package com.qht.model;

import java.io.Serializable;

public class IndexMyCourseTableParam implements Serializable {
	//	学生id
	private String uid;
	//播放类型：1、直播；2、录播',
	private String play_type_id;
	//运营商id
	private String tenant_id;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPlay_type_id() {
		return play_type_id;
	}
	public void setPlay_type_id(String play_type_id) {
		this.play_type_id = play_type_id;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	

}
