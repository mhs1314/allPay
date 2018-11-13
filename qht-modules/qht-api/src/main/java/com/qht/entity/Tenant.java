package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 运营商
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "tenant")
public class Tenant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //名称
    @Column(name = "name")
    private String name;
	
	    //模板
    @Column(name = "temp_id")
    private String tempId;
	
	    //配置
    @Column(name = "config_id")
    private String configId;
	
	    //账号
    @Column(name = "account")
    private String account;
	
	    //密码
    @Column(name = "password")
    private String password;
	

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
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：模板
	 */
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	/**
	 * 获取：模板
	 */
	public String getTempId() {
		return tempId;
	}
	/**
	 * 设置：配置
	 */
	public void setConfigId(String configId) {
		this.configId = configId;
	}
	/**
	 * 获取：配置
	 */
	public String getConfigId() {
		return configId;
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
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
}
