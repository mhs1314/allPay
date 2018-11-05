package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 配置表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "config")
public class Config implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
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
	

	/**
	 * 设置：主键
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：主键
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
}
