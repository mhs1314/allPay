package com.qht.dto;

public class UserSigDto {
	//用户ID-对应学生账号，教师账号
	private String userId;
	//签名
	private String userSig;
	//私钥
	private String privateKey;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserSig() {
		return userSig;
	}
	public void setUserSig(String userSig) {
		this.userSig = userSig;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	
	
}
