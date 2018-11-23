package com.qht.dto;

import java.io.Serializable;

public class AppInsertStudentAskParameter implements Serializable {
public String	uid;
public String	tenant_id;
public String	period_id;
public String	student_id;
public String	question;
public String question_attach;
public String question_url;
	private String teacher_id;

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
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
public String getPeriod_id() {
	return period_id;
}
public void setPeriod_id(String period_id) {
	this.period_id = period_id;
}
public String getStudent_id() {
	return student_id;
}
public void setStudent_id(String student_id) {
	this.student_id = student_id;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getQuestion_attach() {
	return question_attach;
}
public void setQuestion_attach(String question_attach) {
	this.question_attach = question_attach;
}
public String getQuestion_url() {
	return question_url;
}
public void setQuestion_url(String question_url) {
	this.question_url = question_url;
}
@Override
public String toString() {
	return "AppInsertStudentAskParam [uid=" + uid + ", tenant_id=" + tenant_id + ", period_id=" + period_id
			+ ", student_id=" + student_id + ", question=" + question + ", question_attach=" + question_attach
			+ ", question_url=" + question_url + "]";
}

}
