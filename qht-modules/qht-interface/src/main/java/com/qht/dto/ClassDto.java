package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程详情--课程包体系中的class
 */
public class ClassDto implements Serializable {
    //课时id
    private String uid;
    //课时名称
    private String name;
    //课程地址
    private String video_file;
    //开始时间
    private Date begin;

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

    @Override
    public String toString() {
        return "ClassDto{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                '}';
    }
}
