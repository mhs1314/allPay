package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MyIndexBuyRecordModel implements Serializable {

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

    @Override
    public String toString() {
        return "MyIndexBuyRecordDto{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", pkt_type_id='" + pkt_type_id + '\'' +
                ", total_price='" + total_price + '\'' +
                ", nickname='" + nickname + '\'' +
                ", begin=" + begin +
                '}';
    }

    private String cover;

    private String uid;

    private String pkg_name;

    private String pkt_type_id;

    private BigDecimal total_price;

    private String nickname;

    private Date begin;
}
