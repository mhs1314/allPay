package com.qht.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SelectPkgDto implements Serializable {
	private  String uid;
	private String pkg_name;
	private List<SelectChDto> chapterDto=new ArrayList<>();
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
	public List<SelectChDto> getChapterDto() {
		return chapterDto;
	}
	public void setChapterDto(List<SelectChDto> chapterDto) {
		this.chapterDto = chapterDto;
	}
	@Override
	public String toString() {
		return "SelectPkgModel [uid=" + uid + ", pkg_name=" + pkg_name + ", chapter=" + chapterDto + "]";
	}
	

}
