package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class PeriodDetailsDto implements Serializable {
	//课外id
	public String uid;
	//播放类型
	public String play_type_id;
	//课时名称
	public String name;
	//播放地址
	public String video_file;
	//开始时间
	public Date begin;
	//结束时间
	public Date over;
	//课时时长
	public Integer time_length;
	//课程包内容
	public String content;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPlay_type_id() {
		return play_type_id;
	}
	public void setPlay_type_id(String play_type_id) {
		this.play_type_id = play_type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVideo_file() {
		return video_file;
	}
	public void setVideo_file(String video_file) {
		this.video_file = video_file;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getOver() {
		return over;
	}
	public void setOver(Date over) {
		this.over = over;
	}
	public Integer getTime_length() {
		return time_length;
	}
	public void setTime_length(Integer time_length) {
		this.time_length = time_length;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "PeriodDetailsModel [uid=" + uid + ", play_type_id=" + play_type_id + ", name=" + name + ", video_file="
				+ video_file + ", begin=" + begin + ", over=" + over + ", time_length=" + time_length + ", content="
				+ content + "]";
	}
	

}
