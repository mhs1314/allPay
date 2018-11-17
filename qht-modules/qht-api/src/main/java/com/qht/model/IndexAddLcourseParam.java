package com.qht.model;

import java.io.Serializable;

/**
 * @ClassName IndexAddLcourseParameter
 * @Author Zuoxh
 * @Data 2018/11/16 0016 下午 4:04
 */
public class IndexAddLcourseParam implements Serializable {


    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
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

    public String getPkg_edition_id() {
        return pkg_edition_id;
    }

    public void setPkg_edition_id(String pkg_edition_id) {
        this.pkg_edition_id = pkg_edition_id;
    }

    public String getPkg_grade_id() {
        return pkg_grade_id;
    }

    public void setPkg_grade_id(String pkg_grade_id) {
        this.pkg_grade_id = pkg_grade_id;
    }

    public String getPkg_level_id() {
        return pkg_level_id;
    }

    public void setPkg_level_id(String pkg_level_id) {
        this.pkg_level_id = pkg_level_id;
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

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String teacher_id;

    private String tenant_id;

    private String course_type_id;

    private String pkg_subject_id;

    private String pkg_edition_id;

    private String pkg_grade_id;

    private String pkg_level_id;

    private String pkg_name;

    private String play_type_id;

    private String min;

    private String max;

    private String content;

    private String cover;

    private String chapter_name;

    private String period_name;

    private String status="0";

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String uid;

    public String getChapter_uid() {
        return chapter_uid;
    }

    public void setChapter_uid(String chapter_uid) {
        this.chapter_uid = chapter_uid;
    }

    public String getPeriod_uid() {
        return period_uid;
    }

    public void setPeriod_uid(String period_uid) {
        this.period_uid = period_uid;
    }

    @Override
    public String toString() {
        return "IndexAddLcourseParameter{" +
                "teacher_id='" + teacher_id + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                ", course_type_id='" + course_type_id + '\'' +
                ", pkg_subject_id='" + pkg_subject_id + '\'' +
                ", pkg_edition_id='" + pkg_edition_id + '\'' +
                ", pkg_grade_id='" + pkg_grade_id + '\'' +
                ", pkg_level_id='" + pkg_level_id + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", play_type_id='" + play_type_id + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", content='" + content + '\'' +
                ", cover='" + cover + '\'' +
                ", chapter_name='" + chapter_name + '\'' +
                ", period_name='" + period_name + '\'' +
                ", status='" + status + '\'' +
                ", uid='" + uid + '\'' +
                ", chapter_uid='" + chapter_uid + '\'' +
                ", period_uid='" + period_uid + '\'' +
                '}';
    }

    private String chapter_uid;

    private String period_uid;
}
