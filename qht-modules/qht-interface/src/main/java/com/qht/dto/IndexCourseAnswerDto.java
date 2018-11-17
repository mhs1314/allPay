package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class IndexCourseAnswerDto implements Serializable{
	
	private String answer_file_name;
	
	private Date answer_time;
	
	private String question;
	
	private String chapter_name;
	private String video_file;
	private String answer_file_url;
	private String question_attach;
	private String head;
	private String uid;
	private String pkg_name;
	private String question_url;
	private String answer;
	private String nickname;
	private String name;
	private Date begin;
	private String teacher_nickname;
	@Override
	public String toString() {
		return "IndexCourseAnswerDto [answer_file_name=" + answer_file_name + ", answer_time=" + answer_time
				+ ", question=" + question + ", chapter_name=" + chapter_name + ", video_file=" + video_file
				+ ", answer_file_url=" + answer_file_url + ", question_attach=" + question_attach + ", head=" + head
				+ ", uid=" + uid + ", pkg_name=" + pkg_name + ", question_url=" + question_url + ", answer=" + answer
				+ ", nickname=" + nickname + ", name=" + name + ", begin=" + begin + ", teacher_nickname="
				+ teacher_nickname + "]";
	}
	public String getAnswer_file_name() {
		return answer_file_name;
	}
	public void setAnswer_file_name(String answer_file_name) {
		this.answer_file_name = answer_file_name;
	}
	public Date getAnswer_time() {
		return answer_time;
	}
	public void setAnswer_time(Date answer_time) {
		this.answer_time = answer_time;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public String getVideo_file() {
		return video_file;
	}
	public void setVideo_file(String video_file) {
		this.video_file = video_file;
	}
	public String getAnswer_file_url() {
		return answer_file_url;
	}
	public void setAnswer_file_url(String answer_file_url) {
		this.answer_file_url = answer_file_url;
	}
	public String getQuestion_attach() {
		return question_attach;
	}
	public void setQuestion_attach(String question_attach) {
		this.question_attach = question_attach;
	}
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
	public String getPkg_name() {
		return pkg_name;
	}
	public void setPkg_name(String pkg_name) {
		this.pkg_name = pkg_name;
	}
	public String getQuestion_url() {
		return question_url;
	}
	public void setQuestion_url(String question_url) {
		this.question_url = question_url;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public String getTeacher_nickname() {
		return teacher_nickname;
	}
	public void setTeacher_nickname(String teacher_nickname) {
		this.teacher_nickname = teacher_nickname;
	}
	
}
