package com.qht.model;

import java.io.Serializable;

/**
 * @ClassName PCTeacherInfoDto
 * @Author Zuoxh
 * @Data 2018/11/19 0019 下午 8:35
 */
public class PCTeacherInfoModel implements Serializable {
    private Integer sex ;

    private String school_name;

    private String cert;

    private String uid;

    private String intr;

    private String phone;

    private String identity_back;

    private String subject_name;

    private String name;

    private String nickname;

    private String back_img;

    private String age;

    private String indentity_face;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity_back() {
        return identity_back;
    }

    public void setIdentity_back(String identity_back) {
        this.identity_back = identity_back;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
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

    public String getBack_img() {
        return back_img;
    }

    public void setBack_img(String back_img) {
        this.back_img = back_img;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIndentity_face() {
        return indentity_face;
    }

    public void setIndentity_face(String indentity_face) {
        this.indentity_face = indentity_face;
    }

    @Override
    public String toString() {
        return "PCTeacherInfoDto{" +
                "sex=" + sex +
                ", school_name='" + school_name + '\'' +
                ", cert='" + cert + '\'' +
                ", uid='" + uid + '\'' +
                ", intr='" + intr + '\'' +
                ", phone='" + phone + '\'' +
                ", identity_back='" + identity_back + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", back_img='" + back_img + '\'' +
                ", age='" + age + '\'' +
                ", indentity_face='" + indentity_face + '\'' +
                '}';
    }
}
