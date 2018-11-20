package com.qht.dto;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.annotation.JSONField;

/**
 * 创建群组请求参数
 * @author 草原狼
 * @date Nov 20, 2018 3:53:07 PM
 */
public class CreateGroupParameter {
	String Owner_Account = "Web_trtc_01";
	String Type = "ChatRoom";
	String Name = "TestGroup";
	
	//@JSONField(name = "Owner_Account") 
	public String getOwner_Account() {
		return Owner_Account;
	}
	public void setOwner_Account(String owner_Account) {
		Owner_Account = owner_Account;
	}
	//@JSONField(name = "Type") 
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	//@JSONField(name = "Name") 
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String toJson() {				
		//return JSON.toJSONString(this);
		return null;
	}
}
