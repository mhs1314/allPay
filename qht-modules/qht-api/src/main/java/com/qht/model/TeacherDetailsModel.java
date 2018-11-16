package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TeacherDetailsModel  implements Serializable {
    //教师id
    private String uid;
    //基本介绍
    private String intr;
    //积分
    private BigDecimal integral;
    //名称
    private String nickname;
    //科目
    private String subject_name;
    //学校名称
    private String school_name;
    //头像
    private String back_img;
    //点赞数
    private String praise_number;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getPraise_number() {
        return praise_number;
    }

    public void setPraise_number(String praise_number) {
        this.praise_number = praise_number;
    }

	@Override
	public String toString() {
		return "TeacherDetailsModel [uid=" + uid + ", intr=" + intr + ", integral=" + integral + ", nickname=" + nickname
				+ ", subject_name=" + subject_name + ", school_name=" + school_name + ", back_img=" + back_img
				+ ", praise_number=" + praise_number + "]";
	}
    
    
}
