package com.qht.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName IndexMyCourseListDto
 * @Author Zuoxh
 * @Data 2018/11/16 0016 下午 3:30
 */
public class IndexMyCourseListModel implements Serializable {

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCourse_type_name() {
        return course_type_name;
    }

    public void setCourse_type_name(String course_type_name) {
        this.course_type_name = course_type_name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPjg_name() {
        return pjg_name;
    }

    public void setPjg_name(String pjg_name) {
        this.pjg_name = pjg_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getPkg_level_id() {
        return pkg_level_id;
    }

    public void setPkg_level_id(String pkg_level_id) {
        this.pkg_level_id = pkg_level_id;
    }

    @Override
    public String toString() {
        return "IndexMyCourseListDto{" +
                "cover='" + cover + '\'' +
                ", course_type_name='" + course_type_name + '\'' +
                ", uid='" + uid + '\'' +
                ", pjg_name='" + pjg_name + '\'' +
                ", create_time=" + create_time +
                ", pkg_level_id='" + pkg_level_id + '\'' +
                '}';
    }

    private String cover;

    private String course_type_name;

    private String uid;

    private String pjg_name;

    private Date create_time;

    private String pkg_level_id;
}
