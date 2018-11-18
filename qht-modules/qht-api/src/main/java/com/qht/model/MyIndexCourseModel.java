package com.qht.model;

import java.util.Date;

public class MyIndexCourseModel {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
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
        return "MyIndexCourseModel{" +
                "uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", name='" + name + '\'' +
                ", chapter_name='" + chapter_name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                '}';
    }

    private String uid;

    private String pkg_name;

    private String name;

    private String chapter_name;

    private String video_file;

    private Date begin;
}
