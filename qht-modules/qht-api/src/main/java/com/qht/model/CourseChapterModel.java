package com.qht.model;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.List;

public class CourseChapterModel implements Serializable {
    //章节id
    private String uid;
    //章节名称
    private String name;

    //课时集合
    private List<ClassModel> periods;

    public List<ClassModel> getPeriods() {
        return periods;
    }

    public void setPeriods(List<ClassModel> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "CourseChapterModel{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", periods=" + periods +
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


}
