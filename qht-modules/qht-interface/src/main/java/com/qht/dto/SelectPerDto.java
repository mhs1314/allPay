package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class SelectPerDto implements Serializable {
	private String pid;
	private String period_name;
	private String video_file;
	private Date begin;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPeriod_name() {
		return period_name;
	}
	public void setPeriod_name(String period_name) {
		this.period_name = period_name;
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
	@Override
	public String toString() {
		return "SelectPerModel [pid=" + pid + ", period_name=" + period_name + ", video_file=" + video_file + ", begin="
				+ begin + "]";
	}
	

}
