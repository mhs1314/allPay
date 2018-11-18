package com.qht.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qht.common.util.BeanUtil;
import com.qht.dto.SelectPkgDto;

public class SelectPkgModel implements Serializable {
	private  String uid;
	private String pkg_name;
	private String play_type_id;
	private List<SelectChModel> chapter=new ArrayList<>();
	
	
	public String getPlay_type_id() {
		return play_type_id;
	}
	public void setPlay_type_id(String play_type_id) {
		this.play_type_id = play_type_id;
	}
	public SelectPkgDto toDto() {
		SelectPkgDto dto = new SelectPkgDto();
		BeanUtil.copyFields(dto, this);

		for(SelectChModel source : chapter) {
			dto.getChapterDto().add(source.toDto());			
		}
		return dto;
	}
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
	public List<SelectChModel> getChapter() {
		return chapter;
	}
	public void setChapter(List<SelectChModel> chapter) {
		this.chapter = chapter;
	}
	@Override
	public String toString() {
		return "SelectPkgModel [uid=" + uid + ", pkg_name=" + pkg_name + ", chapter=" + chapter + "]";
	}
	

}
