package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 课程包
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "course_pkg")
public class CoursePkg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //课程包类型
    @Column(name = "pkt_type_id")
    private String pktTypeId;
	
	    //课程包科目
    @Column(name = "pkg_subject_id")
    private String pkgSubjectId;
	
	    //课程包版本
    @Column(name = "pkg_edition_id")
    private String pkgEditionId;
	
	    //课程包年级
    @Column(name = "pkg_grade_id")
    private String pkgGradeId;
	
	    //课程包名称
    @Column(name = "pkg_name")
    private String pkgName;
	
	    //课程包播放类型
    @Column(name = "play_type_id")
    private String playTypeId;
	
	    //兑换人数最小值
    @Column(name = "min")
    private String min;
	
	    //兑换人数最大值
    @Column(name = "max")
    private String max;
	
	    //课程开放范围
    @Column(name = "open_ range_id")
    private String openRangeId;
	
	    //课程包主要内容
    @Column(name = "content")
    private String content;
	
	    //课程包主要封面
    @Column(name = "cover")
    private String cover;
	

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
	 * 设置：课程包类型
	 */
	public void setPktTypeId(String pktTypeId) {
		this.pktTypeId = pktTypeId;
	}
	/**
	 * 获取：课程包类型
	 */
	public String getPktTypeId() {
		return pktTypeId;
	}
	/**
	 * 设置：课程包科目
	 */
	public void setPkgSubjectId(String pkgSubjectId) {
		this.pkgSubjectId = pkgSubjectId;
	}
	/**
	 * 获取：课程包科目
	 */
	public String getPkgSubjectId() {
		return pkgSubjectId;
	}
	/**
	 * 设置：课程包版本
	 */
	public void setPkgEditionId(String pkgEditionId) {
		this.pkgEditionId = pkgEditionId;
	}
	/**
	 * 获取：课程包版本
	 */
	public String getPkgEditionId() {
		return pkgEditionId;
	}
	/**
	 * 设置：课程包年级
	 */
	public void setPkgGradeId(String pkgGradeId) {
		this.pkgGradeId = pkgGradeId;
	}
	/**
	 * 获取：课程包年级
	 */
	public String getPkgGradeId() {
		return pkgGradeId;
	}
	/**
	 * 设置：课程包名称
	 */
	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}
	/**
	 * 获取：课程包名称
	 */
	public String getPkgName() {
		return pkgName;
	}
	/**
	 * 设置：课程包播放类型
	 */
	public void setPlayTypeId(String playTypeId) {
		this.playTypeId = playTypeId;
	}
	/**
	 * 获取：课程包播放类型
	 */
	public String getPlayTypeId() {
		return playTypeId;
	}
	/**
	 * 设置：兑换人数最小值
	 */
	public void setMin(String min) {
		this.min = min;
	}
	/**
	 * 获取：兑换人数最小值
	 */
	public String getMin() {
		return min;
	}
	/**
	 * 设置：兑换人数最大值
	 */
	public void setMax(String max) {
		this.max = max;
	}
	/**
	 * 获取：兑换人数最大值
	 */
	public String getMax() {
		return max;
	}
	/**
	 * 设置：课程开放范围
	 */
	public void setOpenRangeId(String openRangeId) {
		this.openRangeId = openRangeId;
	}
	/**
	 * 获取：课程开放范围
	 */
	public String getOpenRangeId() {
		return openRangeId;
	}
	/**
	 * 设置：课程包主要内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：课程包主要内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：课程包主要封面
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * 获取：课程包主要封面
	 */
	public String getCover() {
		return cover;
	}
}
