package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class AppInsertPerIodParam implements Serializable {
	private String 	uid;
	private String tenant_id;
	private String name;
	private String video_file;
	private Date begin;
	private Date over;
	private String chapter_id;
	private Date effective_time;
	private Float time_length;
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
	public String getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(String chapter_id) {
		this.chapter_id = chapter_id;
	}
	public Date getEffective_time() {
		return effective_time;
	}
	public void setEffective_time(Date effective_time) {
		this.effective_time = effective_time;
	}
	public Float getTime_length() {
		return time_length;
	}
	public void setTime_length(Float time_length) {
		this.time_length = time_length;
	}
	@Override
	public String toString() {
		return "AppInsertPerIodParam [uid=" + uid + ", tenant_id=" + tenant_id + ", name=" + name + ", video_file="
				+ video_file + ", begin=" + begin + ", over=" + over + ", chapter_id=" + chapter_id
				+ ", effective_time=" + effective_time + ", time_length=" + time_length + "]";
	}
	

}
