package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 配置表,1
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-22 23:02:42
 */
@Table(name = "config")
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键,0,NO,false,false,false
    @Id
    private String uid;
	
	    //logo
    @Column(name = "logo")
    private String logo;
	
	    //电话
    @Column(name = "phone")
    private String phone;
	
	    //公司名
    @Column(name = "company_name")
    private String companyName;
	
	    //简介
    @Column(name = "intr")
    private String intr;
	
	    //地址
    @Column(name = "addr")
    private String addr;
	
	    //邮编
    @Column(name = "zip")
    private String zip;
	
	    //邮箱
    @Column(name = "mailbox")
    private String mailbox;
	
	    //二位码
    @Column(name = "two_bit_code")
    private String twoBitCode;
	
	    //sdkappid,input,YES,false,true,false
    @Column(name = "sdkappid")
    private String sdkappid;
	
	    //私钥,textarea,YES,false,true,false
    @Column(name = "private_key")
    private String privateKey;
	
	    //公钥,textarea,YES,false,true,false
    @Column(name = "public_key")
    private String publicKey;
	
	    //im-account_type
    @Column(name = "account_type")
    private String accountType;
	
	    //直播-appid
    @Column(name = "appid")
    private String appid;
	
	    //直播-bizid
    @Column(name = "bizid")
    private String bizid;
	
	    //文件上传地址
    @Column(name = "file_upload_addr")
    private String fileUploadAddr;
	

	/**
	 * 设置：主键,0,NO,false,false,false
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：主键,0,NO,false,false,false
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：公司名
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：公司名
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：简介
	 */
	public void setIntr(String intr) {
		this.intr = intr;
	}
	/**
	 * 获取：简介
	 */
	public String getIntr() {
		return intr;
	}
	/**
	 * 设置：地址
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：地址
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置：邮编
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * 获取：邮编
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * 设置：邮箱
	 */
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	/**
	 * 获取：邮箱
	 */
	public String getMailbox() {
		return mailbox;
	}
	/**
	 * 设置：二位码
	 */
	public void setTwoBitCode(String twoBitCode) {
		this.twoBitCode = twoBitCode;
	}
	/**
	 * 获取：二位码
	 */
	public String getTwoBitCode() {
		return twoBitCode;
	}
	/**
	 * 设置：sdkappid,input,YES,false,true,false
	 */
	public void setSdkappid(String sdkappid) {
		this.sdkappid = sdkappid;
	}
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
