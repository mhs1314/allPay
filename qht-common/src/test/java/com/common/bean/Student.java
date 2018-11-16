package com.common.bean;


/**
 * <p>
 * 学生 Mapper 接口
 * </p>
 *
 * @author wangl
 * @since 2018-11-13
 */
public class Student {
	private String account;
	private String password;
	private int sex;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [account=" + account + ", password=" + password + ", sex=" + sex + "]";
	}
	
	
	
}
