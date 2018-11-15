package com.qht.dto;

import java.io.Serializable;

/**
 * @ClassName TeacherListParameter
 * @Author Zuoxh
 * @Data 2018/11/15 0015 下午 8:35
 */
public class TeacherListParameter implements Serializable {
    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getIs_index() {
        return is_index;
    }

    public void setIs_index(Integer is_index) {
        this.is_index = is_index;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getIs_school() {
        return is_school;
    }

    public void setIs_school(Integer is_school) {
        this.is_school = is_school;
    }

    @Override
    public String toString() {
        return "TeacherListParameter{" +
                "tenant_id='" + tenant_id + '\'' +
                ", is_index=" + is_index +
                ", limit=" + limit +
                ", is_school=" + is_school +
                '}';
    }

    private String tenant_id;

    private Integer is_index;

    private Integer limit;

    private Integer is_school;

}
