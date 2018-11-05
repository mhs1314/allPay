package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 提现账户
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //教师ID
    @Column(name = "teacher_id")
    private String teacherId;
	
	    //支付宝账号
    @Column(name = "alipay")
    private String alipay;
	
	    //微信账号
    @Column(name = "wechat")
    private String wechat;
	
	    //银行
    @Column(name = "bank")
    private String bank;
	
	    //户名
    @Column(name = "holder")
    private String holder;
	
	    //账号
    @Column(name = "account")
    private String account;
	
	    //类型
    @Column(name = "type")
    private Integer type;
	

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
	 * 设置：运营商ID
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * 获取：运营商ID
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * 设置：教师ID
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：教师ID
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：支付宝账号
	 */
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	/**
	 * 获取：支付宝账号
	 */
	public String getAlipay() {
		return alipay;
	}
	/**
	 * 设置：微信账号
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * 获取：微信账号
	 */
	public String getWechat() {
		return wechat;
	}
	/**
	 * 设置：银行
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 获取：银行
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 设置：户名
	 */
	public void setHolder(String holder) {
		this.holder = holder;
	}
	/**
	 * 获取：户名
	 */
	public String getHolder() {
		return holder;
	}
	/**
	 * 设置：账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：账号
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public Integer getType() {
		return type;
	}
}
