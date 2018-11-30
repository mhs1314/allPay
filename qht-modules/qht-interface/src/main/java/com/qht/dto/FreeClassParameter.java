package com.qht.dto;

import java.io.Serializable;

/**
 * 首页获取免费课程的参数
 */
public class FreeClassParameter implements Serializable {
    //课程包科目
    private String pkg_subject_id;
    //课程包年级
    private String pkg_grade_id;

    private String tenant_id;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "FreeClassParameter{" +
                "pkg_subject_id='" + pkg_subject_id + '\'' +
                ", pkg_grade_id='" + pkg_grade_id + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
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


}
