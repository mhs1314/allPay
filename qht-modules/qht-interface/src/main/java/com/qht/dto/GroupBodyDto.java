package com.qht.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 群组dto
 * @author 草原狼
 * @date Nov 20, 2018 7:45:59 PM
 */
public class GroupBodyDto {
	private String ActionStatus;
	private String ErrorCode;
	private String GroupId;
	
	@JSONField(name = "ActionStatus") 
	public String getActionStatus() {
		return ActionStatus;
	}
	public void setActionStatus(String actionStatus) {
		ActionStatus = actionStatus;
	}
	@JSONField(name = "ErrorCode") 
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	@JSONField(name = "GroupId") 
	public String getGroupId() {
		return GroupId;
	}
	public void setGroupId(String groupId) {
		GroupId = groupId;
	}
	@Override
	public String toString() {
		return "GroupResponseBodyDto [ActionStatus=" + ActionStatus + ", ErrorCode=" + ErrorCode + ", GroupId="
				+ GroupId + "]";
	}
	
	
	
	
}
