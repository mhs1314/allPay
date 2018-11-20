package com.qht.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TeacherCourseDto implements Serializable {

    private String cover;

    private String uid;

    private String pkg_name;

    private String play_type_id;

    private String pkt_type_id;

    private BigDecimal  total_price;

    private String nickname;

    private Date begin;

    @Override
    public String toString() {
        return "TeacherCourseDto{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", play_type_id='" + play_type_id + '\'' +
                ", pkt_type_id='" + pkt_type_id + '\'' +
                ", total_price=" + total_price +
                ", nickname='" + nickname + '\'' +
                ", begin=" + begin +
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

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    public String getPkt_type_id() {
        return pkt_type_id;
    }

    public void setPkt_type_id(String pkt_type_id) {
        this.pkt_type_id = pkt_type_id;
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
