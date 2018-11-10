package com.qht.dto;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.List;

public class CourseChapterDto implements Serializable {
    //章节id
    private String uid;
    //章节名称
    private String name;
    //课时集合
    private List<ClassDto> classe;

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

    public List<ClassDto> getClasse() {
        return classe;
    }

    public void setClasse(List<ClassDto> classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "CourseChapterDto{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", classe=" + classe +
                '}';
    }


}
