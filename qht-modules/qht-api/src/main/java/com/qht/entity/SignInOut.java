package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 签到签退
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "sign_in_out")
public class SignInOut implements Serializable {
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
	
	    //签到时间
    @Column(name = "sign_in")
    private Date signIn;
	
	    //签退时间
    @Column(name = "sign_out")
    private Date signOut;
	
	    //上课时间
    @Column(name = "begin")
    private Date begin;
	
	    //下课时间
    @Column(name = "over")
    private Date over;
	

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
	 * 设置：签到时间
	 */
	public void setSignIn(Date signIn) {
		this.signIn = signIn;
	}
	/**
	 * 获取：签到时间
	 */
	public Date getSignIn() {
		return signIn;
	}
	/**
	 * 设置：签退时间
	 */
	public void setSignOut(Date signOut) {
		this.signOut = signOut;
	}
	/**
	 * 获取：签退时间
	 */
	public Date getSignOut() {
		return signOut;
	}
	/**
	 * 设置：上课时间
	 */
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	/**
	 * 获取：上课时间
	 */
	public Date getBegin() {
		return begin;
	}
	/**
	 * 设置：下课时间
	 */
	public void setOver(Date over) {
		this.over = over;
	}
	/**
	 * 获取：下课时间
	 */
	public Date getOver() {
		return over;
	}
}
