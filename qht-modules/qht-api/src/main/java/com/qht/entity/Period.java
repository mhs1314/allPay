package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 课时
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "period")
public class Period implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //
    @Id
    private String uid;
	
	    //
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //
    @Column(name = "name")
    private String name;
	
	    //
    @Column(name = "video_file")
    private String videoFile;
	
	    //
    @Column(name = "begin")
    private Date begin;
	
	    //
    @Column(name = "over")
    private Date over;
	

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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setVideoFile(String videoFile) {
		this.videoFile = videoFile;
	}
	/**
	 * 获取：
	 */
	public String getVideoFile() {
		return videoFile;
	}
	/**
	 * 设置：
	 */
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	/**
	 * 获取：
	 */
	public Date getBegin() {
		return begin;
	}
	/**
	 * 设置：
	 */
	public void setOver(Date over) {
		this.over = over;
	}
	/**
	 * 获取：
	 */
	public Date getOver() {
		return over;
	}
}
