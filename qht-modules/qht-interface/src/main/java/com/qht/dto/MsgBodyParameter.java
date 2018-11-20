package com.qht.dto;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class MsgBodyParameter {
	String GroupId;
	List<String> ToMembers_Account;
	String Content;
	
	
	@JSONField(name = "GroupId") 
	public String getGroupId() {
		return GroupId;
	}



	public void setGroupId(String groupId) {
		GroupId = groupId;
	}


	@JSONField(name = "ToMembers_Account")
	public List<String> getToMembers_Account() {
		return ToMembers_Account;
	}



	public void setToMembers_Account(List<String> toMembers_Account) {
		ToMembers_Account = toMembers_Account;
	}


	@JSONField(name = "Content")
	public String getContent() {
		return Content;
	}



	public void setContent(String content) {
		Content = content;
	}



	public String toJson() {				
		return JSON.toJSONString(this);	
	}
	
	
}
