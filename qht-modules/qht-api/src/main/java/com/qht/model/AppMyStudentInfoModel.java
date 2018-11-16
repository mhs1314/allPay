package com.qht.model;

import java.io.Serializable;

public class AppMyStudentInfoModel implements Serializable {
    //学生头像
    private String head;
    //学生id
    private String uid;
    //监护人的电话
    private String phone;
    //监护人的电话
    private String integral;
    //性别
    private String sex;
    //真实姓名
    private String name;
    //学生名称
    private String nickname;
    //千问学校
    private String school_name;
    //年纪名称
    private String grade_name;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

	@Override
	public String toString() {
		return "AppMyStudentInfoDto [head=" + head + ", uid=" + uid + ", phone=" + phone + ", integral=" + integral
				+ ", sex=" + sex + ", name=" + name + ", nickname=" + nickname + ", school_name=" + school_name
				+ ", grade_name=" + grade_name + "]";
	}
    
    
    
}
