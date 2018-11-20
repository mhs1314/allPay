package com.qht.model;

import java.io.Serializable;

public class AppSelectTeacherByidModel implements Serializable {
	//教师id
	private String uid;
	//性别
	private String sex;
	//电话
	private String mobile;
	//教师名称
	private String nickname;
	//教师姓名
	private String name;
	//科目
	private String subject_name;
	//学校名称
	private String school_name;
	//头像
	private String back_img;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getBack_img() {
		return back_img;
	}
	public void setBack_img(String back_img) {
		this.back_img = back_img;
	}
	@Override
	public String toString() {
		return "AppSelectTeacherByid [uid=" + uid + ", sex=" + sex + ", mobile=" + mobile + ", nickname=" + nickname
				+ ", name=" + name + ", subject_name=" + subject_name + ", school_name=" + school_name + ", back_img="
				+ back_img + "]";
	}
	

}
