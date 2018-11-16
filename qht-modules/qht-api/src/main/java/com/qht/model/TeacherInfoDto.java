package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class TeacherInfoDto implements Serializable {
    private String uid;

    private BigDecimal integral;

    private String nickname;

    private String subject_name;

    private String school_name;

    private String back_img;

    private List<CourseModel> course;


    @Override
    public String toString() {
        return "TeacherInfoDto{" +
                "uid='" + uid + '\'' +
                ", integral='" + integral + '\'' +
                ", nickname='" + nickname + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", school_name='" + school_name + '\'' +
                ", back_img='" + back_img + '\'' +
                ", course=" + course +
                '}';
    }



    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public List<CourseModel> getCourse() {
        return course;
    }

    public void setCourse(List<CourseModel> course) {
        this.course = course;
    }
}
