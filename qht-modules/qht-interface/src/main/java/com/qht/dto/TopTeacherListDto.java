package com.qht.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class TopTeacherListDto implements Serializable {
    private String uid;

    private String intr;

    private BigDecimal integral;

    private String nickname;

    private String subject_name;

    private String school_name;

    private List<TopCourseDto> courses;

    private String back_img;

    private Integer course_count;

    private String grade_name;

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

    public List<TopCourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<TopCourseDto> courses) {
        this.courses = courses;
    }

    public String getBack_img() {
        return back_img;
    }

    public void setBack_img(String back_img) {
        this.back_img = back_img;
    }

    public Integer getCourse_count() {
        return course_count;
    }

    public void setCourse_count(Integer course_count) {
        this.course_count = course_count;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    @Override
    public String toString() {
        return "TopTeacherListDto{" +
                "uid='" + uid + '\'' +
                ", intr='" + intr + '\'' +
                ", integral='" + integral + '\'' +
                ", nickname='" + nickname + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", school_name='" + school_name + '\'' +
                ", courses=" + courses +
                ", back_img='" + back_img + '\'' +
                ", course_count=" + course_count +
                ", grade_name='" + grade_name + '\'' +
                '}';
    }

}
