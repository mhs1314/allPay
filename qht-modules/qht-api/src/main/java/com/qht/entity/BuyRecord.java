package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 课程包购买记录
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "buy_record")
public class BuyRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //学生ID
    @Column(name = "student_id")
    private String studentId;
	
	    //支付方式
    @Column(name = "payment_method_id")
    private String paymentMethodId;
	
	    //课程包ID
    @Column(name = "course_pkg_id")
    private String coursePkgId;
	
	    //购买时间
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
	 * 设置：支付方式
	 */
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	/**
	 * 获取：支付方式
	 */
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	/**
	 * 设置：课程包ID
	 */
	public void setCoursePkgId(String coursePkgId) {
		this.coursePkgId = coursePkgId;
	}
	/**
	 * 获取：课程包ID
	 */
	public String getCoursePkgId() {
		return coursePkgId;
	}
	/**
	 * 设置：购买时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：购买时间
	 */
	public Date getTime() {
		return time;
	}
}
