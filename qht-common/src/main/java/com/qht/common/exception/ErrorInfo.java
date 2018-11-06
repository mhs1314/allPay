package com.qht.common.exception;


/**
 * 错误信息
 * @author  草原狼
 *
 * 2017年7月10日
 */

public class ErrorInfo<T> {
	public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private String code;
    private String msg;
    private String url;
    private T data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}    
    
}
