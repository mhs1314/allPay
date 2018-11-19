package com.qht.dto;

public class GroupRequestBodyDto {
	String Owner_Account = "Web_trtc_01";
	String Type = "ChatRoom";
	String Name = "TestGroup";
	
	public String getOwner_Account() {
		return Owner_Account;
	}
	public void setOwner_Account(String owner_Account) {
		Owner_Account = owner_Account;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
