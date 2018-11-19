package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class SelectPeriodByTeacherIdModel implements Serializable {
	private String	uid;
	private Date begin;
	private String	chapter_id;
	private String name;
	private Date over;
	private Date effective_time;
	private String tenant_id;
	private Float time_length;
	private String video_file;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public String getChapter_id() {
		return chapter_id;
	}
	public void setChapter_id(String chapter_id) {
		this.chapter_id = chapter_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getOver() {
		return over;
	}
	public void setOver(Date over) {
		this.over = over;
	}
	public Date getEffective_time() {
		return effective_time;
	}
	public void setEffective_time(Date effective_time) {
		this.effective_time = effective_time;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public Float getTime_length() {
		return time_length;
	}
	public void setTime_length(Float time_length) {
		this.time_length = time_length;
	}
	public String getVideo_file() {
		return video_file;
	}
	public void setVideo_file(String video_file) {
		this.video_file = video_file;
	}
	@Override
	public String toString() {
		return "SelectPeriodByTeacherId [uid=" + uid + ", begin=" + begin + ", chapter_id=" + chapter_id + ", name="
				+ name + ", over=" + over + ", effective_time=" + effective_time + ", tenant_id=" + tenant_id
				+ ", time_length=" + time_length + ", video_file=" + video_file + "]";
	}

}
