package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class TopCourseDto implements Serializable {
    private String cover;

    private String pkg_name;

    private Date begin;


    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }



    @Override
    public String toString() {
        return "TopCourseDto{" +
                "cover='" + cover + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", begin=" + begin +
                '}';
    }
}
