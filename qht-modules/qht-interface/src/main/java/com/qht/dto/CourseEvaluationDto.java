package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class CourseEvaluationDto implements Serializable {

    //学生头像
    private String head;
    //评论id
    private String uid;
    //评论时间
    private Date comments_time;
    //课程包名称
    private String pkg_name;
    //评论星级
    private String comments_stat;
    //评论内容
    private String comments_content;
    //学生姓名
    private String name;


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getComments_time() {
        return comments_time;
    }

    public void setComments_time(Date comments_time) {
        this.comments_time = comments_time;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public String getComments_stat() {
        return comments_stat;
    }

    public void setComments_stat(String comments_stat) {
        this.comments_stat = comments_stat;
    }

    public String getComments_content() {
        return comments_content;
    }

    public void setComments_content(String comments_content) {
        this.comments_content = comments_content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseEvaluationDto{" +
                "head='" + head + '\'' +
                ", uid='" + uid + '\'' +
                ", comments_time=" + comments_time +
                ", pkg_name='" + pkg_name + '\'' +
                ", comments_stat='" + comments_stat + '\'' +
                ", comments_content='" + comments_content + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
