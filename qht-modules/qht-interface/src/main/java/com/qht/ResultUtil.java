package com.qht;

import org.slf4j.Logger;

/**
 * @author  草原狼
 * ResultObjectUtil
 * 2017年9月15日
 */

public class ResultUtil {
	
	/**
	 * 判断为正常返回
	 * @param result
	 * @return
	 */
	public static boolean isOk(ResultObject<?> result) {
		if(result != null && ResultObject.SUCCESS_CODE.equals(result.getCode())) {
			return true;
		}else {
			return false;
		}		
	}
	
	/**
	 * 判断是否为非正确返回
	 * @param result
	 * @return
	 */
	public static boolean notOk(ResultObject<?> result) {
		if(result == null || !ResultObject.SUCCESS_CODE.equals(result.getCode())) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 对远程调用错误时的日志输出
	 * @param result     远程调用的返回值
	 * @param logger     要打印日志的日志类
	 * @param cla        远程调用的类
	 * @param methodName 远程调用的方法
	 */
	public static void printErrorLog(ResultObject<?> result, Logger logger, Class cla, String methodName) {
		if (null == result) {
			logger.error("远程调用{}.{}失败,返回值为{}", cla.getName(), methodName, result);
			return;
		}
		if (!ResultObject.SUCCESS_CODE.equals(result.getCode())) {
			logger.error(
					"远程调用{}.{}失败 * 错误码为:{} * 错误信息为:{}",
					cla.getName(),
					methodName,
					result.getCode(),
					result.getMsg()
			);
		}
	}

}

