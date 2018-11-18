package com.qht.model;

import org.joda.time.DateTime;

import java.io.Serializable;

public class IndexMyCourseParam implements Serializable {

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    public String getCourse_type_id() {
        return course_type_id;
    }

    public void setCourse_type_id(String course_type_id) {
        this.course_type_id = course_type_id;
    }

    public String getPkg_subject_id() {
        return pkg_subject_id;
    }

    public void setPkg_subject_id(String pkg_subject_id) {
        this.pkg_subject_id = pkg_subject_id;
    }

    public String getNow_time() {
        return now_time;
    }

    public void setNow_time(String now_time) {
        this.now_time = now_time;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "IndexMyCourseParam{" +
                "uid='" + uid + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                ", play_type_id='" + play_type_id + '\'' +
                ", course_type_id='" + course_type_id + '\'' +
                ", pkg_subject_id='" + pkg_subject_id + '\'' +
                ", now_time='" + now_time + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }

    private String uid;

    private String tenant_id;

    private String play_type_id;

    private String course_type_id;

    private String pkg_subject_id;

    private String now_time= DateTime.now().toString("yyyy-MM-dd");

    private String page="1";

    private String limit="10";


}
