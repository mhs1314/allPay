package com.qht.model;

import java.io.Serializable;

/**
 * @ClassName TeacherListParam
 * @Author Zuoxh
 * @Data 2018/11/15 0015 下午 8:35
 */
public class TeacherListParam implements Serializable {
    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    @Override
    public String toString() {
        return "TeacherListParam{" +
                "tenant_id='" + tenant_id + '\'' +
                ", limit=" + limit +
                ", school_id='" + school_id + '\'' +
                '}';
    }

    private String tenant_id;


    private Integer limit;

    private String school_id;

}
