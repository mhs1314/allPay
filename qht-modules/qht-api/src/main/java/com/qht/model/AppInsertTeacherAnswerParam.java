package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class AppInsertTeacherAnswerParam implements Serializable {
	private String uid;
	private String tenant_id;
	private String student_id;
	private String ask_id;
	private String append_attach;
	private String answer;
	private String answer_file_name;
	private String type;
	private Date time;
	private Date answer_time;
	private String answer_file_url;
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
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getAsk_id() {
		return ask_id;
	}
	public void setAsk_id(String ask_id) {
		this.ask_id = ask_id;
	}
	public String getAppend_attach() {
		return append_attach;
	}
	public void setAppend_attach(String append_attach) {
		this.append_attach = append_attach;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswer_file_name() {
		return answer_file_name;
	}
	public void setAnswer_file_name(String answer_file_name) {
		this.answer_file_name = answer_file_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(Date answer_time) {
		this.answer_time = answer_time;
	}
	public String getAnswer_file_url() {
		return answer_file_url;
	}
	public void setAnswer_file_url(String answer_file_url) {
		this.answer_file_url = answer_file_url;
	}
	@Override
	public String toString() {
		return "AppInsertTeacherAnswerParam [uid=" + uid + ", tenant_id=" + tenant_id + ", student_id=" + student_id
				+ ", ask_id=" + ask_id + ", append_attach=" + append_attach + ", answer=" + answer
				+ ", answer_file_name=" + answer_file_name + ", type=" + type + ", time=" + time + ", answer_time="
				+ answer_time + ", answer_file_url=" + answer_file_url + "]";
	}
	

}
