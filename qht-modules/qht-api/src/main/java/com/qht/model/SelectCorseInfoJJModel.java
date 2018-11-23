package com.qht.model;

import java.io.Serializable;

public class SelectCorseInfoJJModel implements Serializable {
	private String  pkg_name;
	private String apply_number;
	private String total_price;
	private String level_name;
	private String grade_name;
	private String subject_name;
	private String teacher_name;
	private String back_img;
	private String teacher_grade_name;
	private String school_name;
	private String content;
	private String comments_star;
	public String getPkg_name() {
		return pkg_name;
	}
	public void setPkg_name(String pkg_name) {
		this.pkg_name = pkg_name;
	}
	public String getApply_number() {
		return apply_number;
	}
	public void setApply_number(String apply_number) {
		this.apply_number = apply_number;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getBack_img() {
		return back_img;
	}
	public void setBack_img(String back_img) {
		this.back_img = back_img;
	}
	public String getTeacher_grade_name() {
		return teacher_grade_name;
	}
	public void setTeacher_grade_name(String teacher_grade_name) {
		this.teacher_grade_name = teacher_grade_name;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComments_star() {
		return comments_star;
	}
	public void setComments_star(String comments_star) {
		this.comments_star = comments_star;
	}
	@Override
	public String toString() {
		return "SelectCorseInfoJJModel [pkg_name=" + pkg_name + ", apply_number=" + apply_number + ", total_price="
				+ total_price + ", level_name=" + level_name + ", grade_name=" + grade_name + ", subject_name="
				+ subject_name + ", teacher_name=" + teacher_name + ", back_img=" + back_img + ", teacher_grade_name="
				+ teacher_grade_name + ", school_name=" + school_name + ", content=" + content + ", comments_star="
				+ comments_star + "]";
	}
	

}
