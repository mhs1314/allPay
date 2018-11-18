package com.qht.model;

import java.io.Serializable;
import java.util.Date;

/**
* @author Zuoxh
* @version 创建时间：2018年11月18日 下午2:18:22
* 类说明
*/
public class IndexMyCourseDetailsModel implements Serializable{
	private String uid;
	
	private String play_type_id;
	
	private String name;
	
	private String video_file;
	
	private Date begin;
	
	private String content;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "IndexMyCourseDetailsDto [uid=" + uid + ", play_type_id=" + play_type_id + ", name=" + name
				+ ", video_file=" + video_file + ", begin=" + begin + ", content=" + content + "]";
	}
}
