package com.qht.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程详情--课程包体系中的class
 */
public class ClassModel implements Serializable {
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    @Override
    public String toString() {
        return "ClassDto{" +
                "pid='" + pid + '\'' +
                ", period_name='" + period_name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                '}';
    }

    //课时id
    private String pid;
    //课时名称
    private String period_name;
    //课程地址
    private String video_file;
    //开始时间
    private Date begin;


    public String getVideo_file() {
        return video_file;
    }

    public void setVideo_file(String video_file) {
        this.video_file = video_file;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

}
