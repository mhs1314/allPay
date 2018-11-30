package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName IndexMyCourseDto
 * @Author Zuoxh
 * @Data 2018/11/14 0014 下午 9:43
 */
public class IndexMyCourseDto implements Serializable {

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

    private String uid;

    private String pkg_name;

    private String play_type_id;

    private String name;

    private String chapter_name;

    private String video_file;

    private Date begin;

    private String teacher_name;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    private String cover;

    private String period_id;

    public String getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(String period_id) {
        this.period_id = period_id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return "IndexMyCourseDto{" +
                "uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", play_type_id='" + play_type_id + '\'' +
                ", name='" + name + '\'' +
                ", chapter_name='" + chapter_name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                ", teacher_name='" + teacher_name + '\'' +
                ", cover='" + cover + '\'' +
                ", period_id='" + period_id + '\'' +
                '}';
    }
}
