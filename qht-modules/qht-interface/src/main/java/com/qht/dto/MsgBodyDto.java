package com.qht.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class MsgBodyDto {
	private String ActionStatus;
	private String ErrorCode;
	private String MsgSeq;
	
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
	@JSONField(name = "MsgSeq") 
	public String getMsgSeq() {
		return MsgSeq;
	}
	public void setMsgSeq(String errorInfo) {
		MsgSeq = errorInfo;
	}
	@Override
	public String toString() {
		return "MsgBodyDto [ActionStatus=" + ActionStatus + ", ErrorCode=" + ErrorCode + ", MsgSeq="
				+ MsgSeq + "]";
	}
}
