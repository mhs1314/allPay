package com.qht.common.util;

import java.lang.reflect.Field;

import com.qht.common.constant.ErrorCode;

public class ErrorCodeUtil {
	/**
	 * 根据返回码获取相应信息
	 * @param t
	 * @return
	 */
	public static String getErrorMsg(String code){	
		String result="未知错误";
		try {
			Field field = ErrorCode.class.getField("_"+code);
			result=(String)field.get(ErrorCode.class);	       
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;		
	}
	
	/**
	 * 根据返回码获取相应信息
	 * @param code
	 * @return
	 */
	public static String getErrorMsg(int code){	
		String result="操作失败";
		try {
			Field field = ErrorCode.class.getField("_"+code);
			result=(String)field.get(ErrorCode.class);
	       
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;		
	}
	
	public static void main(String[] args){
		System.out.println("dd"+ErrorCodeUtil.getErrorMsg("329"));
	}
}
