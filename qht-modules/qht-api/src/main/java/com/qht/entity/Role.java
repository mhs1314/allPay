package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 角色
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private String uid;
	
	    //
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //
    @Column(name = "role")
    private String role;
	

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
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * 获取：
	 */
	public String getRole() {
		return role;
	}
}
