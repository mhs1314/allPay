package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 学校
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "school")
public class School implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //banner
    @Column(name = "banner")
    private String banner;
	
	    //学校简介
    @Column(name = "intr")
    private String intr;
	
	    //学校文化
    @Column(name = "culture")
    private String culture;
	

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
	 * 设置：banner
	 */
	public void setBanner(String banner) {
		this.banner = banner;
	}
	/**
	 * 获取：banner
	 */
	public String getBanner() {
		return banner;
	}
	/**
	 * 设置：学校简介
	 */
	public void setIntr(String intr) {
		this.intr = intr;
	}
	/**
	 * 获取：学校简介
	 */
	public String getIntr() {
		return intr;
	}
	/**
	 * 设置：学校文化
	 */
	public void setCulture(String culture) {
		this.culture = culture;
	}
	/**
	 * 获取：学校文化
	 */
	public String getCulture() {
		return culture;
	}
}
