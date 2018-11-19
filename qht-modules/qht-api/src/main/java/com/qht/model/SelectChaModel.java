package com.qht.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.qht.common.util.BeanUtil;
import com.qht.dto.SelectChaDto;
import com.qht.dto.SelectPerDto;

public class SelectChaModel implements Serializable {
	private String uid;
	private String name;
	private List<SelectPerModel> period = new ArrayList<>();
	
	public SelectChaDto toDto() {
		SelectChaDto dto = new SelectChaDto(); 
		BeanUtil.copyFields(dto, this);			
		for(SelectPerModel source : period) {
			dto.getPeriodDto().add(source.toDto());				
		}
		
		return dto;
	}
	
	
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
	public List<SelectPerModel> getPeriod() {
		return period;
	}
	public void setPeriod(List<SelectPerModel> period) {
		this.period = period;
	}
	@Override
	public String toString() {
		return "SelectChModel [c_id=" + uid + ", name=" + name + ", period=" + period + "]";
	}
	

}
