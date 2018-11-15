package com.qht.dto;

import java.io.Serializable;

public class TeacherDto implements Serializable {
	//教师的uid
    private String uid;
    //学校的id
    private String schoolid;
    //昵称
    private String nickname;
    //运营方id
    private String tenant_id;

	public String getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}

	@Override
	public String toString() {
		return "TeacherDto{" +
				"uid='" + uid + '\'' +
				", schoolid='" + schoolid + '\'' +
				", nickname='" + nickname + '\'' +
				", tenant_id='" + tenant_id + '\'' +
				'}';
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


}
