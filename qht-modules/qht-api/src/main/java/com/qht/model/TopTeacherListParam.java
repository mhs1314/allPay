package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TopTeacherListParam implements Serializable {

    private String pkg_subject_id;

    private String pkg_grade_id;

    private String newtime;

    private BigDecimal integral;

    private String tenant_id;

    private String  page="1";


    private String limit="10";

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "TopTeacherListParameter{" +
                "pkg_subject_id='" + pkg_subject_id + '\'' +
                ", pkg_grade_id='" + pkg_grade_id + '\'' +
                ", newtime='" + newtime + '\'' +
                ", integral=" + integral +
                ", tenant_id='" + tenant_id + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                '}';
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

    public String getPkg_grade_id() {
        return pkg_grade_id;
    }

    public void setPkg_grade_id(String pkg_grade_id) {
        this.pkg_grade_id = pkg_grade_id;
    }

    public String getNewtime() {
        return newtime;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }


}
