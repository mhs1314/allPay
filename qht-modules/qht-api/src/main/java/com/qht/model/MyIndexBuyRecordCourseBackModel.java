package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class MyIndexBuyRecordCourseBackModel implements Serializable {
    public Date getEffective_time() {
        return effective_time;
    }

    public void setEffective_time(Date effective_time) {
        this.effective_time = effective_time;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo_file() {
        return video_file;
    }

    public void setVideo_file(String video_file) {
        this.video_file = video_file;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    @Override
    public String toString() {
        return "MyIndexBuyRecourdCourseBackDto{" +
                "effective_time=" + effective_time +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                '}';
    }

    private Date effective_time;

    private String uid;

    private String pkg_name;

    private String nickname;

    private String name;

    private String video_file;

    private Date begin;
}
