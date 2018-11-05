package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 附件表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "attach")
public class Attach implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //文件名
    @Column(name = "file_name")
    private String fileName;
	
	    //文件路径
    @Column(name = "file_url")
    private String fileUrl;
	
	    //文件大小
    @Column(name = "file_size")
    private String fileSize;
	
	    //文件类型
    @Column(name = "file_type")
    private String fileType;
	
	    //创建人ID
    @Column(name = "create_user_id")
    private String createUserId;
	
	    //创建人
    @Column(name = "create_user_name")
    private String createUserName;
	
	    //创建时间
    @Column(name = "create_time")
    private Date createTime;
	
	    //修改人ID
    @Column(name = "modify_user_id")
    private String modifyUserId;
	
	    //修改时间
    @Column(name = "modify_time")
    private Date modifyTime;
	
	    //修改人
    @Column(name = "modify_user_name")
    private String modifyUserName;
	

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
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * 设置：文件路径
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	/**
	 * 获取：文件路径
	 */
	public String getFileUrl() {
		return fileUrl;
	}
	/**
	 * 设置：文件大小
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	/**
	 * 获取：文件大小
	 */
	public String getFileSize() {
		return fileSize;
	}
	/**
	 * 设置：文件类型
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	/**
	 * 获取：文件类型
	 */
	public String getFileType() {
		return fileType;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人ID
	 */
	public String getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUserName() {
		return createUserName;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改人ID
	 */
	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId;
	}
	/**
	 * 获取：修改人ID
	 */
	public String getModifyUserId() {
		return modifyUserId;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName;
	}
	/**
	 * 获取：修改人
	 */
	public String getModifyUserName() {
		return modifyUserName;
	}
}
