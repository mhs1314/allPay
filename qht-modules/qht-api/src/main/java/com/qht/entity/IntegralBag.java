package com.qht.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 积分套餐
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "integral_bag")
public class IntegralBag implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //积分
    @Column(name = "integral")
    private BigDecimal integral;
	
	    //金额
    @Column(name = "money")
    private BigDecimal money;
	
	    //是否促销
    @Column(name = "promotion")
    private Integer promotion;
	
	    //时间
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
	 * 设置：是否促销
	 */
	public void setPromotion(Integer promotion) {
		this.promotion = promotion;
	}
	/**
	 * 获取：是否促销
	 */
	public Integer getPromotion() {
		return promotion;
	}
	/**
	 * 设置：时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * 获取：时间
	 */
	public Date getTime() {
		return time;
	}
}
