package com.qht.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qht.common.util.BeanUtil;
import com.qht.dto.SelectChaDto;
import com.qht.dto.SelectPerDto;

public class SelectChaDto implements Serializable {
	private String uid;
	private String name;
	private List<SelectPerDto> periodDto = new ArrayList<>();
	
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<SelectPerDto> getPeriodDto() {
		return periodDto;
	}
	public void setPeriodDto(List<SelectPerDto> periodDto) {
		this.periodDto = periodDto;
	}
	@Override
	public String toString() {
		return "SelectChModel [c_id=" + uid + ", name=" + name + ", period=" + periodDto + "]";
	}
	

}
