package com.qht.dto;

public class GroupResponseBodyDto {
	private String ActionStatus;
	private String ErrorCode;
	private String GroupId;
	
	public String getActionStatus() {
		return ActionStatus;
	}
	public void setActionStatus(String actionStatus) {
		ActionStatus = actionStatus;
	}
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
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
