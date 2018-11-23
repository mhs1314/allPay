package com.qht.model;

import java.io.Serializable;

/**
 * @ClassName EditTeacherInfoParameter
 * @Author Zuoxh
 * @Data 2018/11/19 0019 下午 9:00
 */
public class EditTeacherInfoParam implements Serializable {

    private String uid;

    private String sex;

    private String school_name;

    private String cert;

    private String intr;

    private String mobile;

    private String identity_back;

    private String indentuty_face;

    private String name;

    private String nickname;

    private String back_img;

    private String age;

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

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdentity_back() {
        return identity_back;
    }

    public void setIdentity_back(String identity_back) {
        this.identity_back = identity_back;
    }

    public String getIndentuty_face() {
        return indentuty_face;
    }

    public void setIndentuty_face(String indentuty_face) {
        this.indentuty_face = indentuty_face;
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

    @Override
    public String toString() {
        return "EditTeacherInfoParameter{" +
                "uid='" + uid + '\'' +
                ", sex='" + sex + '\'' +
                ", school_name='" + school_name + '\'' +
                ", cert='" + cert + '\'' +
                ", intr='" + intr + '\'' +
                ", mobile='" + mobile + '\'' +
                ", identity_back='" + identity_back + '\'' +
                ", indentuty_face='" + indentuty_face + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", back_img='" + back_img + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
