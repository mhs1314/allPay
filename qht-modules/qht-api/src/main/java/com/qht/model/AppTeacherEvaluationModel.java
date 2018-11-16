package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class AppTeacherEvaluationModel implements Serializable {
    //学生头像
    private String head;
    //教师评论id
    private String uid;
    //评论星级
    private BigDecimal comments_star;
    //学生名称
    private String name;
    //课时名称
    private String period_name;
    //评论时间
    private String time;
    //评论内容
    private String content;

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

    public BigDecimal getComments_star() {
        return comments_star;
    }

    public void setComments_star(BigDecimal comments_star) {
        this.comments_star = comments_star;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "AppTeacherEvaluationDto [head=" + head + ", uid=" + uid + ", comments_star=" + comments_star + ", name="
				+ name + ", period_name=" + period_name + ", time=" + time + ", content=" + content + "]";
	}
    
    
}
