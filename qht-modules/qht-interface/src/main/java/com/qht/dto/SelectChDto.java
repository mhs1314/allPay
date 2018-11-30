package com.qht.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SelectChDto implements Serializable {
	private String c_id;
	private String name;
	private List<SelectPerDto> periodDto=new ArrayList<>();
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
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
		return "SelectChModel [c_id=" + c_id + ", name=" + name + ", period=" + periodDto + "]";
	}
	

}
