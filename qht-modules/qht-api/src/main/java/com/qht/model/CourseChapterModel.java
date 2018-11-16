package com.qht.model;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.List;

public class CourseChapterModel implements Serializable {
    //章节id
    private String uid;
    //章节名称
    private String name;

    public List<ClassModel> getPeriod() {
        return period;
    }

    public void setPeriod(List<ClassModel> period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "CourseChapterModel{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", period=" + period +
                '}';
    }

    //课时集合
    private List<ClassModel> period;

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


}
