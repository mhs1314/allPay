package com.qht;

import java.util.Arrays;
import java.util.List;

/**
 * 分页添加查询
 * @author 草原狼
 * @date Jul 11, 2018 5:35:00 PM
 */
public class PageDto<T> {
	
	public static final int DEFAULT_PAGE = 1;
	public static final int DEFAULT_PAGE_SIZE = 12;
	/**
     * 条件字段
     */
	private String[] searchFields;
    /**
     * 条件 如"like",">","<","=",等等。 <br/>
     * 条件拼凑语句: <br/>
     * searchFields[i]+" "+condition[i]+" "+searchValues[i]+" and "+searchFields[i+1]+" "+condition[i+1]+" "+searchValues[i+1]
     */
	private String[] condition;
    /**
     * 条件内容
     */
	private String[] searchValues;
    /**
     * 排序字段
     */
	private String orderField;
    /**
     * 排序方式
     */
	private OrderType orderType;
	/**
	 * 分组字段
	 */
	private String[] groupByFields;
	/**
	 * 是否使用 DISTINCT
	 */
	private Boolean distinct;
    /**
     * 当页页码
     */
	private Integer current;
    /**
     * 每页记录数
     */
	private Integer pageSize;
    /**
     * 总记录数
     */
	private long total=0L;
	 /**
     * 总页数
     */
	private long pages=0L;
	
	/**
     * 备用字段
     */
	private Object Spare;
	public Object getSpare() {
		return Spare;
	}
	public void setSpare(Object spare) {
		Spare = spare;
	}
	/**
	 * 返回结果
	 */
	private List<T> data;

	public String[] getSearchFields() {
		return searchFields;
	}
	public String[] getCondition() {
		return condition;
	}
	public String[] getSearchValues() {
		return searchValues;
	}
	public String getOrderField() {
		return orderField;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public String[] getGroupByFields() {
		return groupByFields;
	}
	public Boolean isDistinct() {
		return distinct;
	}
	
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Long getTotal() {
		return total;
	}
	
	public void setSearchFields(String[] searchFields) {
		this.searchFields = searchFields;
	}
	public void setCondition(String[] condition) {
		this.condition = condition;
	}
	public void setSearchValues(String[] searchValues) {
		this.searchValues = searchValues;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public void setOrderType(String orderType) {
		this.orderType = OrderType.valueOf(orderType);
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	public void setGroupByFields(String[] groupByFields) {
		this.groupByFields = groupByFields;
	}
	public void setDistinct(Boolean distinct) {
		this.distinct = distinct;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Page [searchFields=" + Arrays.toString(searchFields) + ", condition=" + Arrays.toString(condition)
				+ ", searchValues=" + Arrays.toString(searchValues) + ", orderField=" + orderField + ", orderType="
				+ orderType + ", groupByFields=" + Arrays.toString(groupByFields) + ", distinct=" + distinct + ", page="
				+ current + ", pageNum=" + pageSize + ", total=" + total + ", rows=" + pages + ", data=" + data + "]";
	}


	public static <E, T> PageDto<E> convert(PageDto<T> page, List<E> data) {
		PageDto<E> ePage = new PageDto<>();
		ePage.setPages(page.getPages());
		ePage.setTotal(page.getTotal());
		ePage.setCurrent(page.getCurrent());
		ePage.setPageSize(page.getPageSize());
		ePage.setData(data);
		return ePage;
	}
	public Long getPages() {
		return pages;
	}
	public void setPages(long pages) {
		this.pages = pages;
	}
	public Object  extendData;

	public Object getExtendData() {
		return extendData;
	}

	public void setExtendData(Object extendData) {
		this.extendData = extendData;
	}
}
