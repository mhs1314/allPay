package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CourseListModel implements Serializable {
    //课程包封面
    private String cover;
    //课程包uid
    private String uid;
    //课程包名称
    private String pkg_name;
    //总积分
    private BigDecimal total_price;
    //老师名称
    private String nickname;
    //课时开始时间
    private Date begin;

    private String play_type_id;

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    @Override
    public String toString() {
        return "CourseListModel{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", total_price=" + total_price +
                ", nickname='" + nickname + '\'' +
                ", begin=" + begin +
                ", play_type_id='" + play_type_id + '\'' +
                '}';
    }

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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }


}
