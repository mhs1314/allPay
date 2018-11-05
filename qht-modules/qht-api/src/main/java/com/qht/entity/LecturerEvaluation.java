package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 讲师评价
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "lecturer_evaluation")
public class LecturerEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private String uid;
	
	    //
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //
    @Column(name = "teacher_id")
    private String teacherId;
	
	    //
    @Column(name = "student_id")
    private String studentId;
	
	    //
    @Column(name = "score")
    private Integer score;
	
	    //
    @Column(name = "high")
    private Integer high;
	
	    //
    @Column(name = "middle")
    private Integer middle;
	
	    //
    @Column(name = "low")
    private Integer low;
	
	    //
    @Column(name = "content")
    private Integer content;
	
	    //
    @Column(name = "time")
    private Date time;
	

	/**
	 * 设置：
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	/**
	 * 获取：
	 */
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * 设置：
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * 设置：
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * 获取：
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * 设置：
	 */
	public void setHigh(Integer high) {
		this.high = high;
	}
	/**
	 * 获取：
	 */
	public Integer getHigh() {
		return high;
	}
	/**
	 * 设置：
	 */
	public void setMiddle(Integer middle) {
		this.middle = middle;
	}
	/**
	 * 获取：
	 */
	public Integer getMiddle() {
		return middle;
	}
	/**
	 * 设置：
	 */
	public void setLow(Integer low) {
		this.low = low;
	}
	/**
	 * 获取：
	 */
	public Integer getLow() {
		return low;
	}
	/**
	 * 设置：
	 */
	public void setContent(Integer content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public Integer getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：
	 */
	public Date getTime() {
		return time;
	}
}
