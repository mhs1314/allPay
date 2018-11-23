package com.qht.dto;

public class ConfigDto {

	private String sdkappid;	
	private String privateKey;	
	private String publicKey;	
	private String accountType;	
	private String appid;	
	private String bizid;	
	private String fileUploadAddr;


	/**
	 * 获取：sdkappid,input,YES,false,true,false
	 */
	public String getSdkappid() {
		return sdkappid;
	}

	/**
	 * 设置：私钥,textarea,YES,false,true,false
	 */
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	/**
	 * 获取：私钥,textarea,YES,false,true,false
	 */
	public String getPrivateKey() {
		return privateKey;
	}

	/**
	 * 设置：公钥,textarea,YES,false,true,false
	 */
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	/**
	 * 获取：公钥,textarea,YES,false,true,false
	 */
	public String getPublicKey() {
		return publicKey;
	}

	/**
	 * 设置：im-account_type
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * 获取：im-account_type
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * 设置：直播-appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * 获取：直播-appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * 设置：直播-bizid
	 */
	public void setBizid(String bizid) {
		this.bizid = bizid;
	}

	/**
	 * 获取：直播-bizid
	 */
	public String getBizid() {
		return bizid;
	}

	/**
	 * 设置：文件上传地址
	 */
	public void setFileUploadAddr(String fileUploadAddr) {
		this.fileUploadAddr = fileUploadAddr;
	}

	/**
	 * 获取：文件上传地址
	 */
	public String getFileUploadAddr() {
		return fileUploadAddr;
	}
	
}
