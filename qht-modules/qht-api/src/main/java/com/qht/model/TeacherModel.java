package com.qht.model;

import java.io.Serializable;

public class TeacherModel implements Serializable {
	//教师的uid
    private String uid;
    //学校的id
    private String schoolid;
    //昵称
    private String nickname;
    //运营方id
    private String tenant_id;
  //用户名
    private String name;
    
    private String account;
    
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}

	@Override
	public String toString() {
		return "TeacherModel{" +
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
