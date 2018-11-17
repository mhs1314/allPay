package com.qht;

import static com.qht.ResultObject.ERROR_CODE;
import static com.qht.ResultObject.ERROR_MSG;
import static com.qht.ResultObject.SUCCESS_CODE;
import static com.qht.ResultObject.SUCCESS_MSG;

import com.qht.common.util.ErrorCodeUtil;

/**
 * 结果打包工具类
 * @author 草原狼
 * @date 2018-9-9
 */
public class ResultBuilder {
	
	public static <T> ResultObject<T> success(String requestId){
		return new ResultObject<T>(requestId).setCode(SUCCESS_CODE).setMsg(SUCCESS_MSG);
	}
	public static <T> ResultObject<T> success(RequestObject<T> requestObject) {
        return createResult(requestObject.getRequestId(), SUCCESS_CODE, SUCCESS_MSG, null);
    }

    public static <T> ResultObject<T> success(RequestObject<?> requestObject, T data) {
        return createResult(requestObject.getRequestId(), SUCCESS_CODE, SUCCESS_MSG, data);
    }   
    public static <T> ResultObject<T> success(String requestId, T data) {
        return createResult(requestId, SUCCESS_CODE, SUCCESS_MSG, data);
    }  

    // 参数校验没通过时 aop使用
    public static <T> ResultObject<T> error(String requestId, String code, String message) {
        return createResult(requestId, code, message, null);
    } 
    
    public static <T> ResultObject<T> error(RequestObject<?> request, String code, String message) {
        return createResult(request.getRequestId(), code, message, null);
    }  
    
    
    public static <T> ResultObject<T> error(RequestObject<?> requestObject, String code) {
        return createResult(requestObject.getRequestId(), code, ErrorCodeUtil.getErrorMsg(code), null);
    }  
    
    public static <T> ResultObject<T> error(String requestId, String code) {
        return createResult(requestId, code, ErrorCodeUtil.getErrorMsg(code), null);
    } 

    // 未知异常时 aop使用
    public static <T> ResultObject<T> error(RequestObject<T> requestObject) {
        return createResult(requestObject.getRequestId(), ERROR_CODE, ERROR_MSG, null);
    }   

    private static <T> ResultObject<T> createResult(String requestId, String code, String message, T data) {
        return new ResultObject<T>(requestId).setCode(code).setMsg(message).setData(data);
    }
}
