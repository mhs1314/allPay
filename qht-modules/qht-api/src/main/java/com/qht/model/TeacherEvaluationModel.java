package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class TeacherEvaluationModel implements Serializable {

    private String head;
    //评论id
    private String uid;
    //时间
    private Date comments_time;

    private String pkg_name;
    //评论星星
    private String comments_star;
    //评论内容
    private String comments_content;
    //学生姓名
    private String name;
    //积分
    private Integer eval;
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
	public String getComments_star() {
		return comments_star;
	}
	public void setComments_star(String comments_star) {
		this.comments_star = comments_star;
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
	public Integer getEval() {
		return eval;
	}
	public void setEval(Integer eval) {
		this.eval = eval;
	}
	@Override
	public String toString() {
		return "TeacherEvaluationModel [head=" + head + ", uid=" + uid + ", comments_time=" + comments_time
				+ ", pkg_name=" + pkg_name + ", comments_star=" + comments_star + ", comments_content="
				+ comments_content + ", name=" + name + ", eval=" + eval + "]";
	}
    
    
}
