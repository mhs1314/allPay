package com.qht.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 直播课程
 */
public class LiveClassModel implements Serializable {
    //封面
    private String cover;
    //课时id
    private String uid;
    //班级名称
    private String level_name;
    //课程名称
    private String name;
    //视频地址
    private String  video_file;
    //开始时间
    private Date begin;

    private String play_type_id;

    private String teacehr_name;

    public String getTeacehr_name() {
        return teacehr_name;
    }

    public void setTeacehr_name(String teacehr_name) {
        this.teacehr_name = teacehr_name;
    }

    @Override
    public String toString() {
        return "LiveClassModel{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", level_name='" + level_name + '\'' +
                ", name='" + name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                ", play_type_id='" + play_type_id + '\'' +
                ", teacehr_name='" + teacehr_name + '\'' +
                '}';
    }

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
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

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }


}
