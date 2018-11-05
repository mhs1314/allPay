package com.qht.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;


/**
 * 提现记录
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "extract_record")
public class ExtractRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //教师ID
    @Column(name = "teacher_id")
    private String teacherId;
	
	    //支付积分
    @Column(name = "integral")
    private BigDecimal integral;
	
	    //兑换金额
    @Column(name = "money")
    private BigDecimal money;
	
	    //支付方式
    @Column(name = "payment_method_id")
    private String paymentMethodId;
	
	    //提现时间
    @Column(name = "time")
    private Date time;
	
	    //提现状态
    @Column(name = "status")
    private Integer status;
	

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
	 * 设置：教师ID
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：教师ID
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：支付积分
	 */
	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}
	/**
	 * 获取：支付积分
	 */
	public BigDecimal getIntegral() {
		return integral;
	}
	/**
	 * 设置：兑换金额
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	/**
	 * 获取：兑换金额
	 */
	public BigDecimal getMoney() {
		return money;
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
	 * 设置：提现时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：提现时间
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * 设置：提现状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：提现状态
	 */
	public Integer getStatus() {
		return status;
	}
}
