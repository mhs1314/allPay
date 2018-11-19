package com.qht.model;

import java.io.Serializable;

/**
 * @ClassName IndexMyCourseListParameter
 * @Author Zuoxh
 * @Data 2018/11/16 0016 下午 3:22
 */
public class IndexMyCourseListParam implements Serializable {

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

    private String  course_type_id;

    private String uid;

    private String tenant_id;

    @Override
    public String toString() {
        return "IndexMyCourseListParam{" +
                "course_type_id='" + course_type_id + '\'' +
                ", uid='" + uid + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    private String page;

    private String limit;


}
