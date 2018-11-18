package com.qht.auth.util;



public class QhtJWTInfo {
    //用户ID
	private String uid;
	// 运营商ID
	private String tenantId;
	// 昵称
	private String nickname;
	// 姓名
	private String name;
    //账号
	private String account;
	
	
	
	public QhtJWTInfo(String uid, String tenantId, String nickname, String name, String account) {
		super();
		this.uid = uid;
		this.tenantId = tenantId;
		this.nickname = nickname;
		this.name = name;
		this.account = account;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
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

}
