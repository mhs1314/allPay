package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

/**
* @author Zuoxh
* @version 创建时间：2018年11月18日 下午1:08:50
* 类说明
*/
public class IndexMessageDto implements Serializable{
	
	private String head;
	
	private String uid;
	
	private String isread;
	
	private String nickname;
	
	private Date time;
	
	private String contenet;

	@Override
	public String toString() {
		return "IndexMessageDto [head=" + head + ", uid=" + uid + ", isread=" + isread + ", nickname=" + nickname
				+ ", time=" + time + ", contenet=" + contenet + "]";
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

	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContenet() {
		return contenet;
	}

	public void setContenet(String contenet) {
		this.contenet = contenet;
	}
	
}
