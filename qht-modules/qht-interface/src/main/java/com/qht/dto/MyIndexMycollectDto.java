package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class MyIndexMycollectDto implements Serializable {

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCollect_time() {
        return collect_time;
    }

    public void setCollect_time(Date collect_time) {
        this.collect_time = collect_time;
    }

    @Override
    public String toString() {
        return "MyIndexMycollectDto{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", pkt_type_id='" + pkt_type_id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", collect_time=" + collect_time +
                '}';
    }

    private String cover;

    private String uid;

    private String pkg_name;

    private String pkt_type_id;

    private String nickname;

    private Date collect_time;
}
