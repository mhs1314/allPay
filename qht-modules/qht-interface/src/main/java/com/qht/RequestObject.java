package com.qht;

import com.qht.dto.ReqBaseDto;

/**
 * 请求数据
 * @author 草原狼
 * @date Jul 10, 2018 10:14:37 AM
 */
public class RequestObject<T>  {
	/**
	 * 请求ID，便于跟踪业务数据
	 */
	private String requestId;
	/**
	 * 请求数据
	 */
    private T data;
    
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
	
	public RequestObject() {
		super();
	}
	public RequestObject(String requestId, T data) {
		super();
		this.requestId = requestId;
		this.data = data;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestObject other = (RequestObject) obj;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RequestObject [requestId=" + requestId + ", data=" + data + "]";
	}
	
	
    
}
