package com.qht.model;

import java.io.Serializable;

public class IndexCourseAnswerParam implements Serializable{
	
	private String uid;
	
	private String tenant_id;
	
	private String answer;
	
	private String page="1";
	
	private String limit="10";

	@Override
	public String toString() {
		return "IndexCourseAnswerParameter [uid=" + uid + ", tenant_id=" + tenant_id + ", answer=" + answer + ", page="
				+ page + ", limit=" + limit + "]";
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

}
