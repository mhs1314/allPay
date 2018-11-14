package com.qht.dto;

import java.io.Serializable;

public class IndexAnswerDetailsExceptionalParameter implements Serializable {
    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IndexAnswerDetailsExceptionalParameter{" +
                "teacher_id='" + teacher_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                ", value=" + value +
                '}';
    }

    private String teacher_id;

    private String student_id;

    private String tenant_id;

    private Integer value;
}
