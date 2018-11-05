package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 学校画册
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "album")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //学校风采
    @Column(name = "album")
    private String album;
	
	    //顺序
    @Column(name = "`index`")
    private Integer index;
	

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
	 * 设置：学校风采
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	/**
	 * 获取：学校风采
	 */
	public String getAlbum() {
		return album;
	}
	/**
	 * 设置：顺序
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}
	/**
	 * 获取：顺序
	 */
	public Integer getIndex() {
		return index;
	}
}
