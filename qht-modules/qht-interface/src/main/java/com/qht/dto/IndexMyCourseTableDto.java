package com.qht.dto;

import java.io.Serializable;

public class IndexMyCourseTableDto implements Serializable {
	//课时id
	private String uid;
	//课程包名称
	private String pkg_name;
	//课时名称
	private String name;
	//章节名称
	private String chapter_name;
	//video_file
	private String video_file;
	//开始时间
	private String begin;
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
	public String getVideo_file() {
		return video_file;
	}
	public void setVideo_file(String video_file) {
		this.video_file = video_file;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	

}
