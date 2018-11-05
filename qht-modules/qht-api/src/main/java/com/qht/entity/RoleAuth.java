package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 角色权限
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "role_auth")
public class RoleAuth implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //角色ID
    @Column(name = "role_id")
    private String roleId;
	
	    //权限ID
    @Column(name = "auth_id")
    private String authId;
	

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
	 * 设置：角色ID
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：角色ID
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * 设置：权限ID
	 */
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	/**
	 * 获取：权限ID
	 */
	public String getAuthId() {
		return authId;
	}
}
