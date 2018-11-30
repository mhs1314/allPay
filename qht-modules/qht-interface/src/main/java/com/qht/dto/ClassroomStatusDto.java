package com.qht.dto;

public class ClassroomStatusDto {
	//管理员ID
	private String admin_nick;
	//管理员ID
	private String admin_id;
	//屏幕状态
	private String home_screen;
	
	
	public String getAdmin_nick() {
		return admin_nick;
	}
	public void setAdmin_nick(String admin_nick) {
		this.admin_nick = admin_nick;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getHome_screen() {
		return home_screen;
	}
	public void setHome_screen(String home_screen) {
		this.home_screen = home_screen;
	}
	
}
