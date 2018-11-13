package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 课程答疑
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "answer")
public class Answer implements Serializable {
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
	
	    //问题ID
    @Column(name = "ask_id")
    private String askId;
	
	    //追问
    @Column(name = "append_ask")
    private String appendAsk;
	
	    //追问附件
    @Column(name = "append_attach")
    private String appendAttach;
	
	    //回答
    @Column(name = "answer")
    private String answer;
	
	    //回答附件
    @Column(name = "answer_attach")
    private String answerAttach;
	
	    //type
    @Column(name = "type")
    private Integer type;
	
	    //创建时间
    @Column(name = "time")
    private Date time;
	

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
	 * 设置：问题ID
	 */
	public void setAskId(String askId) {
		this.askId = askId;
	}
	/**
	 * 获取：问题ID
	 */
	public String getAskId() {
		return askId;
	}
	/**
	 * 设置：追问
	 */
	public void setAppendAsk(String appendAsk) {
		this.appendAsk = appendAsk;
	}
	/**
	 * 获取：追问
	 */
	public String getAppendAsk() {
		return appendAsk;
	}
	/**
	 * 设置：追问附件
	 */
	public void setAppendAttach(String appendAttach) {
		this.appendAttach = appendAttach;
	}
	/**
	 * 获取：追问附件
	 */
	public String getAppendAttach() {
		return appendAttach;
	}
	/**
	 * 设置：回答
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/**
	 * 获取：回答
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * 设置：回答附件
	 */
	public void setAnswerAttach(String answerAttach) {
		this.answerAttach = answerAttach;
	}
	/**
	 * 获取：回答附件
	 */
	public String getAnswerAttach() {
		return answerAttach;
	}
	/**
	 * 设置：type
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：创建时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getTime() {
		return time;
	}
}
