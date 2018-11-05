package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 课程提问
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "course_ask")
public class CourseAsk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //课时ID
    @Column(name = "period_id")
    private String periodId;
	
	    //学生ID
    @Column(name = "student_id")
    private String studentId;
	
	    //问题
    @Column(name = "question")
    private String question;
	
	    //问题附件
    @Column(name = "question_attach")
    private String questionAttach;
	

	/**
	 * 设置：主键
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：主键
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：运营商ID
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * 获取：运营商ID
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * 设置：课时ID
	 */
	public void setPeriodId(String periodId) {
		this.periodId = periodId;
	}
	/**
	 * 获取：课时ID
	 */
	public String getPeriodId() {
		return periodId;
	}
	/**
	 * 设置：学生ID
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：学生ID
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * 设置：问题
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * 获取：问题
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * 设置：问题附件
	 */
	public void setQuestionAttach(String questionAttach) {
		this.questionAttach = questionAttach;
	}
	/**
	 * 获取：问题附件
	 */
	public String getQuestionAttach() {
		return questionAttach;
	}
}
