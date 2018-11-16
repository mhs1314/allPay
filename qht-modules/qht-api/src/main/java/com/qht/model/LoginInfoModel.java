package com.qht.model;


import java.io.Serializable;

/**
 * 登陆信息
 * @author 草原狼
 * @date 2018-11-8
 */
public class LoginInfoModel implements Serializable {
	//运营商ID
	private String tenantId;
    //账号   
    private String account;	
	//密码    
    private String password;

    
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginInfoDto [tenantId=" + tenantId + ", account=" + account + ", password=" + password + "]";
	}
    
    
}
