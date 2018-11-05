package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 兴趣标签
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "interest_label")
public class InterestLabel implements Serializable {
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
	
	    //标签ID
    @Column(name = "tag_id")
    private String tagId;
	

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
	 * 设置：标签ID
	 */
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	/**
	 * 获取：标签ID
	 */
	public String getTagId() {
		return tagId;
	}
}
