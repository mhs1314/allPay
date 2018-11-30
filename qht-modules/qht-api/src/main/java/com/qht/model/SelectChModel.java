package com.qht.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qht.common.util.BeanUtil;
import com.qht.dto.SelectChDto;
import com.qht.dto.SelectPerDto;

public class SelectChModel implements Serializable {
	private String c_id;
	private String name;
	private List<SelectPerModel> period = new ArrayList<>();
	
	public SelectChDto toDto() {
		SelectChDto dto = new SelectChDto(); 
		BeanUtil.copyFields(dto, this);			
		for(SelectPerModel source : period) {
			dto.getPeriodDto().add(source.toDto());				
		}
		
		return dto;
	}
	
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
	public List<SelectPerModel> getPeriod() {
		return period;
	}
	public void setPeriod(List<SelectPerModel> period) {
		this.period = period;
	}
	@Override
	public String toString() {
		return "SelectChModel [c_id=" + c_id + ", name=" + name + ", period=" + period + "]";
	}
	

}
