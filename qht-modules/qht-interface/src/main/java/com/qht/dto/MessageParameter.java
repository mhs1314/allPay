package com.qht.dto;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class MessageParameter {
	
	private String group_id;
	private List<String> member;
	private String content;
	
	@JSONField(name = "group_id") 
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	
	@JSONField(name = "member")
	public List<String> getMember() {
		return member;
	}
	public void setMember(List<String> member) {
		this.member = member;
	}
	
	@JSONField(name = "content")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MessageParameter [group_id=" + group_id + ", member=" + member + ", content=" + content + "]";
	}
	
	
}
