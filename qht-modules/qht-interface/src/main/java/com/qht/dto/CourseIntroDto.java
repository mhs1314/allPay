package com.qht.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CourseIntroDto implements Serializable {
    //课程包封面
    private String cover;
    //课程包uid
    private String uid;
    //课程包名字
    private String pkg_name;
    //课程包价格
    private BigDecimal total_price;
    //老师名称
    private String nickname;
    //科目
    private String subject_name;
    //开始时间
    private Date begin;
    //年级
    private String grade_name;
    //课程内容
    private String content;
    //报名人数
    private Integer apply_number;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getApply_number() {
        return apply_number;
    }

    public void setApply_number(Integer apply_number) {
        this.apply_number = apply_number;
    }

    @Override
    public String toString() {
        return "CourseIntroDto{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", total_price='" + total_price + '\'' +
                ", nickname='" + nickname + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", begin=" + begin +
                ", grade_name='" + grade_name + '\'' +
                ", content='" + content + '\'' +
                ", apply_number=" + apply_number +
                '}';
    }


}
