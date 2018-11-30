package com.qht.dto;

import java.io.Serializable;

/**
* @author Zuoxh
* @version 创建时间：2018年11月18日 下午1:05:53
* 类说明
*/
public class IndexMessageParameter implements Serializable{
	
	private String uid;
	
	private String tenant_id;
	
	private String page="1";
	
	private String limit="10";
	
	private String isread;

	@Override
	public String toString() {
		return "IndexMessageParameter [uid=" + uid + ", tenant_id=" + tenant_id + ", page=" + page + ", limit=" + limit
				+ ", isread=" + isread + "]";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTenant_id() {
		return tenant_id;
	}

	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}
	
}
