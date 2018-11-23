package com.qht.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoDto implements Serializable {
    public String getCalzz() {
        return calzz;
    }

    public void setCalzz(String calzz) {
        this.calzz = calzz;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public List<GuardianDto> getGuardian() {
        return guardian;
    }

    public void setGuardian(List<GuardianDto> guardian) {
        this.guardian = guardian;
    }

    @Override
    public String toString() {
        return "StudentInfoDto{" +
                "uid='" + uid + '\'' +
                ", head='" + head + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", school_name='" + school_name + '\'' +
                ", calzz='" + calzz + '\'' +
                ", grade_name='" + grade_name + '\'' +
                ", age='" + age + '\'' +
                ", integral=" + integral +
                ", guardian=" + guardian +
                '}';
    }

    //學生id
    private String uid;
    //學生頭像
    private String head;
    //性別
    private String sex;
    //姓名
    private String name;
    //昵稱
    private String nickname;
    //學校id
    private String school_name;
    //班級名稱
    private String calzz;
    //練級名稱
    private String grade_name;
    //年紀名稱
    private String age;

    private Integer integral;
    //監護人
    private List<GuardianDto> guardian=new ArrayList<>();

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
