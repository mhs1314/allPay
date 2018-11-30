package com.qht.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MyIndexCourseDto implements Serializable {
    private String uid;

    private String pkg_name;

    private String cover;

    private String play_type_id;

    private String pkt_type_id;

    private String total_price;

    private String teacher_name;

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    @Override
    public String toString() {
        return "MyIndexCourseDto{" +
                "uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", cover='" + cover + '\'' +
                ", play_type_id='" + play_type_id + '\'' +
                ", pkt_type_id='" + pkt_type_id + '\'' +
                ", total_price='" + total_price + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", chapters=" + chapters +
                '}';
    }

    private List<ChapterDto> chapters;

    public List<ChapterDto> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterDto> chapters) {
        this.chapters = chapters;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

}
