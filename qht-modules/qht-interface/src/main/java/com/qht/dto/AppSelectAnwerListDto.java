package com.qht.dto;

import java.io.Serializable;

public class AppSelectAnwerListDto implements Serializable {
	private String head;
	private String uid;
	private String question;
	private String answer;
	private String nickname;
	private String subject_name	;
	private String type;
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AppSelectAnwerList [head=" + head + ", uid=" + uid + ", question=" + question + ", answer=" + answer
				+ ", nickname=" + nickname + ", subject_name=" + subject_name + ", type=" + type + "]";
	}
	

}
