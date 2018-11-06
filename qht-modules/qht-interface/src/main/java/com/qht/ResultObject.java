package com.qht;



/**
 * rest接口响应结果
 * @author 草原狼
 * @date 2017-6-29
 */
public class ResultObject<T> {

    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MSG = "success";
    public static final String ERROR_CODE = "1";
    public static final String ERROR_MSG = "error";

    /**
     * 请求序列号，必须与RequestObject.requestId一致
     * 此属性不暴露set方法，仅在构造时传入
     */
    private String requestId;
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回描述
     */
    private String msg;
    private String errorMsg;
    /**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public ResultObject<T> setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}

	/**
     * 请求数据
     */	
    private T data;

    public ResultObject() {
    	this.code = "0";
    	this.msg = "接口调用成功";    	
    }

    public ResultObject(String requestId) {
    	this();
        this.requestId = requestId;
    }

    @SuppressWarnings("rawtypes")
    public ResultObject(RequestObject request) {
        this(request.getRequestId());
    }

    @SuppressWarnings("rawtypes")
    public ResultObject(RequestObject request, String code, String msg) {
        this(request);
        this.code = code;
        this.msg = msg;
    }

    @SuppressWarnings("rawtypes")
    public ResultObject(RequestObject request, String code, String msg, T data) {
        this(request, code, msg);
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public ResultObject<T> setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ResultObject<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultObject<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultObject<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

    @Override
    public String toString() {
        return "ResultObject [requestId=" + requestId + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }
}

