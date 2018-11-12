package com.qht.dto;

import javax.sql.rowset.serial.SerialBlob;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 名师详情--讲师简介
 */
public class TopTeacherInfoDto implements Serializable {

    private String uid;

    private String intr;

    private Date create_time;

    private BigDecimal integral;

    private String nickname;

    private String subject_name;

    private String school_name;

    private String back_img;

    private Integer praise_number;

    private List<CourseDto> course;


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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
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

    public Integer getPraise_number() {
        return praise_number;
    }

    public void setPraise_number(Integer praise_number) {
        this.praise_number = praise_number;
    }

    public List<CourseDto> getCourse() {
        return course;
    }

    public void setCourse(List<CourseDto> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "TopTeacherInfoDto{" +
                "uid='" + uid + '\'' +
                ", intr='" + intr + '\'' +
                ", create_time=" + create_time +
                ", integral=" + integral +
                ", nickname='" + nickname + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", school_name='" + school_name + '\'' +
                ", back_img='" + back_img + '\'' +
                ", praise_number='" + praise_number + '\'' +
                ", course=" + course +
                '}';
    }

}
