package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class SelectPeriodByTeacherIdModel implements Serializable {
	 public String uid;
	 public String  pkg_name;
	public String name;
	public String chapter_name;
	public Date begin;
	public String video_file;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChapter_name() {
		return chapter_name;
	}
	public void setChapter_name(String chapter_name) {
		this.chapter_name = chapter_name;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public String getVideo_file() {
		return video_file;
	}
	public void setVideo_file(String video_file) {
		this.video_file = video_file;
	}
	@Override
	public String toString() {
		return "SelectPeriodByTeacherIdDto [uid=" + uid + ", pkg_name=" + pkg_name + ", name=" + name
				+ ", chapter_name=" + chapter_name + ", begin=" + begin + ", video_file=" + video_file + "]";
	}
}
