package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 站内消息
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Table(name = "message")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //主键
    @Id
    private String uid;
	
	    //运营商ID
    @Column(name = "tenant_id")
    private String tenantId;
	
	    //消息来源
    @Column(name = "from_id")
    private String fromId;
	
	    //消息目标
    @Column(name = "to_id")
    private String toId;
	
	    //消息标题
    @Column(name = "title")
    private String title;
	
	    //消息内容
    @Column(name = "content")
    private String content;
	
	    //消息附件
    @Column(name = "attach")
    private String attach;
	
	    //消息类型
    @Column(name = "type")
    private Integer type;
	

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
	 * 设置：消息来源
	 */
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	/**
	 * 获取：消息来源
	 */
	public String getFromId() {
		return fromId;
	}
	/**
	 * 设置：消息目标
	 */
	public void setToId(String toId) {
		this.toId = toId;
	}
	/**
	 * 获取：消息目标
	 */
	public String getToId() {
		return toId;
	}
	/**
	 * 设置：消息标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：消息标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：消息内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：消息内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：消息附件
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}
	/**
	 * 获取：消息附件
	 */
	public String getAttach() {
		return attach;
	}
	/**
	 * 设置：消息类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：消息类型
	 */
	public Integer getType() {
		return type;
	}
}
