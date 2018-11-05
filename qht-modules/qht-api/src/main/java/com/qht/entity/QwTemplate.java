package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 模板表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "qw_template")
public class QwTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //模板名称
    @Column(name = "name")
    private String name;
	
	    //模板样式
    @Column(name = "style")
    private String style;
	

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
	 * 设置：模板名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：模板名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：模板样式
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * 获取：模板样式
	 */
	public String getStyle() {
		return style;
	}
}
