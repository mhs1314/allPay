package com.qht.common.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * set方法
 * @author yangtonggan
 * @date 2017-1-7
 */
public class GetSetMethodUtil {
	private static final Logger logger = LoggerFactory.getLogger(GetSetMethodUtil.class);
	/**
	 * 获取ge方法
	 * @param c
	 * @param fieldName
	 * @return
	 */
	public static Method obtainGetMethod(Class<?> c,String fieldName){		
		try {			 
			 PropertyDescriptor pd=new PropertyDescriptor(fieldName,c);
	         Method getMethod=pd.getReadMethod();
	         return getMethod;
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获取set方法
	 * @param c
	 * @param fieldName
	 * @return
	 */
	public static Method obtainSetMethod(Class<?> c,String fieldName){
		try{
			 PropertyDescriptor pd=new PropertyDescriptor(fieldName,c);
			 Method getMethod=pd.getWriteMethod();
	         return getMethod;
		}catch(Exception e){
			logger.debug(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		
	}
	
}

