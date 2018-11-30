package com.qht.dto;

import java.io.Serializable;

public class IndexTeacherListParameter  implements Serializable {
    //运营商id
    private String tenant_id;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "IndexTeacherListParameter{" +
                "tenant_id='" + tenant_id + '\'' +
                ", pkg_grade_id='" + pkg_grade_id + '\'' +
                ", subject_id='" + subject_id + '\'' +
                ", praise_number='" + praise_number + '\'' +
                '}';
    }

    //年级ID
    private String pkg_grade_id;

    public String getPkg_grade_id() {
        return pkg_grade_id;
    }

    public void setPkg_grade_id(String pkg_grade_id) {
        this.pkg_grade_id = pkg_grade_id;
    }

    //科目ID
    private String subject_id;
    // 大于点赞数
    private String praise_number;    




	public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getPraise_number() {
        return praise_number;
    }

    public void setPraise_number(String praise_number) {
        this.praise_number = praise_number;
    }
}
