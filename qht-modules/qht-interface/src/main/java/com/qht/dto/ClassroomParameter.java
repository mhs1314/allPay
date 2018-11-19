package com.qht.dto;

/**
 * 课堂参数
 * @author 草原狼
 * @date Nov 19, 2018 6:32:17 PM
 */
public class ClassroomParameter {
	//当前的直播课堂ID
	private String class_id;
    //教师ID
	private String teacher_id;
	//学生ID
	private String student_id;
	//屏幕状态
	private String home_screen;
	
	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getHome_screen() {
		return home_screen;
	}

	public void setHome_screen(String home_screen) {
		this.home_screen = home_screen;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	
	
}
