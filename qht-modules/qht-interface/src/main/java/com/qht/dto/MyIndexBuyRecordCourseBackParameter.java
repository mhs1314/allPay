package com.qht.dto;

import java.io.Serializable;

public class MyIndexBuyRecordCourseBackParameter implements Serializable {

    @Override
    public String toString() {
        return "MyIndexBuyRecourdCourseBackParameter{" +
                "uid='" + uid + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                ", pkg_subject_id='" + pkg_subject_id + '\'' +
                '}';
    }

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

    public String getPkg_subject_id() {
        return pkg_subject_id;
    }

    public void setPkg_subject_id(String pkg_subject_id) {
        this.pkg_subject_id = pkg_subject_id;
    }

    private String uid;

    private String tenant_id;

    private String page="1";

    private String limit="10";

    private String pkg_subject_id;
}
