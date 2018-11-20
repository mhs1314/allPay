package com.qht.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SumSelectCoursePkgPingDto implements Serializable {
	private Integer count_bad;
	private Integer count;
	private Integer count_good;
	private Integer count_mid;
	private List<SelectCoursePkgPingDto> list=new ArrayList<>();
	public Integer getCount_bad() {
		return count_bad;
	}
	public void setCount_bad(Integer count_bad) {
		this.count_bad = count_bad;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCount_good() {
		return count_good;
	}
	public void setCount_good(Integer count_good) {
		this.count_good = count_good;
	}
	public Integer getCount_mid() {
		return count_mid;
	}
	public void setCount_mid(Integer count_mid) {
		this.count_mid = count_mid;
	}
	public List<SelectCoursePkgPingDto> getList() {
		return list;
	}
	public void setList(List<SelectCoursePkgPingDto> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "SumSelectCoursePkgPingDto [count_bad=" + count_bad + ", count=" + count + ", count_good=" + count_good
				+ ", count_mid=" + count_mid + ", list=" + list + "]";
	}
	
}
