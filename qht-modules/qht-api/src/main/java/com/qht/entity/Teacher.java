package com.qht.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 教师
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "teacher")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private String uid;
	
	    //
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //
    @Column(name = "school_id")
    private String schoolId;
	
	    //
    @Column(name = "nickname")
    private String nickname;
	
	    //
    @Column(name = "head")
    private String head;
	
	    //
    @Column(name = "sex")
    private Integer sex;
	
	    //
    @Column(name = "age")
    private String age;
	
	    //
    @Column(name = "school")
    private String school;
	
	    //
    @Column(name = "clazz")
    private String clazz;
	
	    //
    @Column(name = "mobile")
    private String mobile;
	
	    //
    @Column(name = "cert")
    private String cert;
	
	    //
    @Column(name = "identity_face")
    private String identityFace;
	
	    //
    @Column(name = "identity_back")
    private String identityBack;
	
	    //
    @Column(name = "identity_num")
    private String identityNum;
	
	    //
    @Column(name = "intr")
    private String intr;
	
	    //
    @Column(name = "recommend")
    private Integer recommend;
	
	    //
    @Column(name = "integral")
    private BigDecimal integral;
	
	    //
    @Column(name = "amount")
    private BigDecimal amount;
	
	    //账号
    @Column(name = "account")
    private String account;
	
	    //密码
    @Column(name = "password")
    private String password;
	

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
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * 获取：
	 */
	public String getSchoolId() {
		return schoolId;
	}
	/**
	 * 设置：
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：
	 */
	public void setHead(String head) {
		this.head = head;
	}
	/**
	 * 获取：
	 */
	public String getHead() {
		return head;
	}
	/**
	 * 设置：
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * 获取：
	 */
	public String getAge() {
		return age;
	}
	/**
	 * 设置：
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	/**
	 * 获取：
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * 设置：
	 */
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	/**
	 * 获取：
	 */
	public String getClazz() {
		return clazz;
	}
	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：
	 */
	public void setCert(String cert) {
		this.cert = cert;
	}
	/**
	 * 获取：
	 */
	public String getCert() {
		return cert;
	}
	/**
	 * 设置：
	 */
	public void setIdentityFace(String identityFace) {
		this.identityFace = identityFace;
	}
	/**
	 * 获取：
	 */
	public String getIdentityFace() {
		return identityFace;
	}
	/**
	 * 设置：
	 */
	public void setIdentityBack(String identityBack) {
		this.identityBack = identityBack;
	}
	/**
	 * 获取：
	 */
	public String getIdentityBack() {
		return identityBack;
	}
	/**
	 * 设置：
	 */
	public void setIdentityNum(String identityNum) {
		this.identityNum = identityNum;
	}
	/**
	 * 获取：
	 */
	public String getIdentityNum() {
		return identityNum;
	}
	/**
	 * 设置：
	 */
	public void setIntr(String intr) {
		this.intr = intr;
	}
	/**
	 * 获取：
	 */
	public String getIntr() {
		return intr;
	}
	/**
	 * 设置：
	 */
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	/**
	 * 获取：
	 */
	public Integer getRecommend() {
		return recommend;
	}
	/**
	 * 设置：
	 */
	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getIntegral() {
		return integral;
	}
	/**
	 * 设置：
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * 设置：账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：账号
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
}
