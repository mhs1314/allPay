package com.qht.model;


import java.util.List;

public class MyIndexBuyRecordCourseDetailsModel {

    @Override
    public String toString() {
        return "MyIndexBuyRecordCourseDetailsModel{" +
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

    public List<ClassModel> getPeriod() {
        return period;
    }

    public void setPeriod(List<ClassModel> period) {
        this.period = period;
    }

    private String uid;

    private String name;

    private List<ClassModel> period;




}
