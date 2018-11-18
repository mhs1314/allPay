package com.qht.dto;

import java.io.Serializable;
import java.util.List;

/**
* @author Zuoxh
* @version 创建时间：2018年11月18日 下午2:50:55
* 类说明
*/
public class indexMyCourseEditPeriodDto implements Serializable{
	private String uid;
	
	private List<ClassDto> period;
	
	@Override
	public String toString() {
		return "indexMyCourseEditPeriodDto [uid=" + uid + ", period=" + period + ", name=" + name + "]";
	}

	private String name;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<ClassDto> getPeriod() {
		return period;
	}

	public void setPeriod(List<ClassDto> period) {
		this.period = period;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
