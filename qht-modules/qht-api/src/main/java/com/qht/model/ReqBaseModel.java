/**
 * 
 */
package com.qht.model;

import java.util.List;

/**
 * @author pqbaojian
 * @date 2018年7月10日 下午5:05:29
 */
public class ReqBaseModel {
	
	//字段名称
	private List<String> fields = null;
	//字段值
	private List<String> values = null;
	//操作方式
	private List<String> conditions = null;
	
	
	/**
	 * @return the fields
	 */
	public List<String> getFields() {
		return fields;
	}
	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	/**
	 * @return the values
	 */
	public List<String> getValues() {
		return values;
	}
	/**
	 * @param values the values to set
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}
	/**
	 * @return the conditions
	 */
	public List<String> getConditions() {
		return conditions;
	}
	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(List<String> conditions) {
		this.conditions = conditions;
	}
	private int page  = 1;
	private int pageSize  = 10;
	private int  totalCount;
	private int  totalPageCount;
	private String orderByField;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Boolean getAsc() {
		return isAsc;
	}

	public void setAsc(Boolean asc) {
		isAsc = asc;
	}

	@Override
	public String toString() {
		return "ReqBaseDto{" +
				"fields=" + fields +
				", values=" + values +
				", conditions=" + conditions +
				", page=" + page +
				", pageSize=" + pageSize +
				", totalCount=" + totalCount +
				", totalPageCount=" + totalPageCount +
				", orderByField='" + orderByField + '\'' +
				", tenantId='" + tenantId + '\'' +
				", isAsc=" + isAsc +
				'}';
	}

	private String tenantId;
	private Boolean isAsc;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public String getOrderByField() {
		return orderByField;
	}
	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}
	public Boolean getIsAsc() {
		return isAsc;
	}
	public void setIsAsc(Boolean isAsc) {
		this.isAsc = isAsc;
	}
	
   
	
}
