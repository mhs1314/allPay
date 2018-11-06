package com.qht;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页条件
 * @author 草原狼
 * @date Jul 11, 2018 5:47:08 PM
 */
public class PageQueryTerm<T> {
	private List<String> fields = null;
	private List<String> values = null;
	private List<String> conditions = null;
	private List<String> groupByFields = null;
	private Boolean distinct = null;
	
 
	private PageDto<T> page = null;
	
	public PageQueryTerm(PageDto<T> page){
		this.fields = new ArrayList<String>();
		this.values = new ArrayList<String>();
		this.conditions = new ArrayList<String>();
		this.groupByFields = new ArrayList<String>();
		this.distinct = false;
		this.page = page;
		
	}
	
	public Boolean getDistinct() {
		return distinct;
	}

	public void setDistinct(Boolean distinct) {
		this.distinct = distinct;
	}
	
	/**
	 * 添加条件
	 * @param field 字段名
	 * @param value 字段值
	 * @param opt   操作符（"like",">","<","="）
	 */
	public void addTerm(String field,String value,String opt){
		fields.add(field);
		values.add(value);
		conditions.add(opt);
	}
	
	/**
	 * 添加条件
	 * @param field 字段名
	 * @param value 字段值
	 * @param opt   操作符（"like",">","<","="）
	 */
	public void addTerm(String field,String value,String opt,String group){
		fields.add(field);
		values.add(value);
		conditions.add(opt);
		groupByFields.add(group);
	}
	/**
	 * 获取分页条件
	 * @return
	 */
	public PageDto<T> getPageTerm(){
		if(page.getPageSize() <= 0){
			page.setPageSize(12);
		}					
		page.setSearchFields(new String[fields.size()]);
		
		fields.toArray(page.getSearchFields());		
		page.setSearchValues(new String[values.size()]);
		values.toArray(page.getSearchValues());		
		page.setCondition(new String[conditions.size()]);
		conditions.toArray(page.getCondition());
		page.setGroupByFields(new String[groupByFields.size()]);
		groupByFields.toArray(page.getGroupByFields());
		page.setDistinct(getDistinct());
		return page;
	}

}
