package com.qht.dto;

import java.io.Serializable;

public class CoursePkgListDto  implements Serializable{
	private String uid;
	private String pkg_name;
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
	

}
