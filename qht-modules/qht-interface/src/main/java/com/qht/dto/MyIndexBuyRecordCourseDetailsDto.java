package com.qht.dto;


import java.util.List;

public class MyIndexBuyRecordCourseDetailsDto {

    @Override
    public String toString() {
        return "MyIndexBuyRecordCourseDetailsDto{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", period=" + period +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassDto> getPeriod() {
        return period;
    }

    public void setPeriod(List<ClassDto> period) {
        this.period = period;
    }

    private String uid;

    private String name;

    private List<ClassDto> period;




}
