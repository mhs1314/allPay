package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 登录日志
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "login_log")
public class LoginLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String tenantId;
	
	    //账号
    @Column(name = "account")
    private String account;
	
	    //登录终端
    @Column(name = "terminal")
    private Integer terminal;
	
	    //登录时间
    @Column(name = "time")
    private Date time;
	

	/**
	 * 设置：主键
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * 获取：主键
	 */
	public String getTenantId() {
		return tenantId;
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
	 * 设置：登录终端
	 */
	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}
	/**
	 * 获取：登录终端
	 */
	public Integer getTerminal() {
		return terminal;
	}
	/**
	 * 设置：登录时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：登录时间
	 */
	public Date getTime() {
		return time;
	}
}
