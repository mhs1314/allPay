package com.qht.dto;

import java.io.Serializable;

public class IndexTeacherListParameter  implements Serializable {
    //运营商id
    private String tenant_id;
    //年级ID
    private String grade_id;
    //科目ID
    private String subject_id;
    // 大于点赞数
    private String praise_number;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

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
