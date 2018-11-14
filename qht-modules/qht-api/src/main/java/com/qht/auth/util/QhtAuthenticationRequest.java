package com.qht.auth.util;

import java.io.Serializable;

public class QhtAuthenticationRequest implements Serializable {
	
	private static final long serialVersionUID = 8929021628526939143L;
	//登录账号
	private String account;
	//登录密码
	private String password;
    //1-平台,2-运营商,3-教师,4-学生
	private int type;
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
