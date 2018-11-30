package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class IndexCourseDetailsDto implements Serializable {
    //课时uid
    private String uid;

    private String name;

    private String video_file;

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
        return "IndexCourseDetailsDto{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                '}';
    }
}
