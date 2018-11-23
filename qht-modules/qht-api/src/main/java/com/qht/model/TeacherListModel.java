package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 老师列表
 */
public class TeacherListModel implements Serializable {
    //老师介绍
    private String intr;
    //学校名称
    private String school;
    //评分
    private BigDecimal integral;
    //性别
    private Integer sex;
    //老师名字
    private String nickname;
    //头像
    private String back_img;
    //课程包数量
    private Integer pkg_count;

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getPkg_count() {
        return pkg_count;
    }

    public void setPkg_count(Integer pkg_count) {
        this.pkg_count = pkg_count;
    }

    @Override
    public String toString() {
        return "TeacherListModel{" +
                "intr='" + intr + '\'' +
                ", school='" + school + '\'' +
                ", integral=" + integral +
                ", sex=" + sex +
                ", nickname='" + nickname + '\'' +
                ", back_img='" + back_img + '\'' +
                ", pkg_count=" + pkg_count +
                '}';
    }


}
