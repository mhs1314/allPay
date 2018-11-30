package com.qht.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 充值记录
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "recharge_record")
public class RechargeRecord implements Serializable {
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
	
	    //积分
    @Column(name = "integral")
    private BigDecimal integral;
	
	    //金额
    @Column(name = "money")
    private BigDecimal money;
	
	    //充值时间
    @Column(name = "time")
    private Date time;
	
	    //支付方式
    @Column(name = "payment_method_id")
    private String paymentMethodId;
	

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
	 * 设置：积分
	 */
	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}
	/**
	 * 获取：积分
	 */
	public BigDecimal getIntegral() {
		return integral;
	}
	/**
	 * 设置：金额
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	/**
	 * 获取：金额
	 */
	public BigDecimal getMoney() {
		return money;
	}
	/**
	 * 设置：充值时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：充值时间
	 */
	public Date getTime() {
		return time;
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
}
