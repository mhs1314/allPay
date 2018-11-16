package com.qht.dto;

import java.io.Serializable;

/**
 * @ClassName IndexMyCourseListParameter
 * @Author Zuoxh
 * @Data 2018/11/16 0016 下午 3:22
 */
public class IndexMyCourseListParameter implements Serializable {

    public String getCourse_type_id() {
        return course_type_id;
    }

    public void setCourse_type_id(String course_type_id) {
        this.course_type_id = course_type_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTennat_id() {
        return tennat_id;
    }

    public void setTennat_id(String tennat_id) {
        this.tennat_id = tennat_id;
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
        return "IndexMyCourseListParameter{" +
                "course_type_id='" + course_type_id + '\'' +
                ", uid='" + uid + '\'' +
                ", tennat_id='" + tennat_id + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }

    private String  course_type_id;

    private String uid;

    private String tennat_id;

    private String page;

    private String limit;


}
