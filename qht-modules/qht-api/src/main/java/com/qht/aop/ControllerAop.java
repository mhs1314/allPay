package com.qht.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.qht.RequestObject;
import com.qht.ResultBuilder;
import com.qht.common.exception.BizException;

/**
 * @author 草原狼
 * 2018/9/3
 * 目前主要用于日志记录
 */
@Aspect
@Component
public class ControllerAop {
	
	private static final Logger log = LoggerFactory.getLogger(ControllerAop.class);
	private static final String LOG_FORMAT = "class.method[{}], args \n{}, result \n{}";

	@Around("execution(public * com.qht.rest..*.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Exception {
		String clazz = pjp.getTarget().getClass().getName();
		String method = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		Object returnVal = null;
		Throwable ex = null;
		try {			
			before(pjp);
			returnVal = pjp.proceed();

		} catch (Throwable e) {
			ex = e;
			RequestObject<?> request = (RequestObject<?>)args[0];
            if (e instanceof BizException) {
                BizException biz = (BizException) e;
                returnVal = ResultBuilder.error(request,biz.getCode(), biz.getMsg());
            } else {
                returnVal = ResultBuilder.error(request);
            }
		} finally {
			after(pjp);
			printLog(clazz, method, args, returnVal, ex);
		}

		if (ex!=null && ex instanceof  Exception){
			throw  ((Exception) ex);
		}
		return returnVal;
	}

	public static void printLog(String clazz, String method, Object[] args, Object returnVal, Throwable e) {
		Object arg = null;
		if (args != null && args.length > 0) {
			arg = args[0];
		}
		String methodName = clazz + "." + method;
		if (e == null || e instanceof BizException) {
			log.info(LOG_FORMAT, methodName, toJSON(arg), toJSON(returnVal));
		} else {
			log.error(LOG_FORMAT, methodName, toJSON(arg), toJSON(returnVal), e);
		}
	}

	private static String toJSON(Object obj) {
		try {
			return JSON.toJSONString(obj, true);
		} catch (Throwable e) {
			if (obj != null) {
				return obj.toString();
			} else {
				return null;
			}
		}
	}

	//aop前置操作
	private void before(ProceedingJoinPoint pjp) {
		
	}

	//aop后置操作
	private void after(ProceedingJoinPoint pjp) {
		
	}

}
