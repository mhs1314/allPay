package com.qht.dto;

import java.io.Serializable;

public class CourseDto implements Serializable {
    //课程包名称
    private String pkg_name;

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "pkg_name='" + pkg_name + '\'' +
                '}';
    }


}
