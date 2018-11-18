package com.qht.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StringUtil {
	/**
	 * 判断参数有空为true,否则为false
	 * @param strs
	 * @return
	 */
	public static boolean hasEmpty(String... strs){
		for(String str : strs) {
			if(isEmpty(str)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断字符串对象是否为nul或空串
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 判断字符串是否不为空
	 */
	public static boolean notEmpty(String str){
		return !isEmpty(str);
	}
	
	/**
	 * 判断对象是否不为空
	 */
	public static boolean isEmpty(Object str){
		if(str instanceof String){
			return isEmpty((String)str);
		}else{
			return isEmpty(String.valueOf(str));
		}
	}
	
	/**
	 * 判断对象是否不为空
	 */
	public static boolean notEmpty(Object str){
		return !isEmpty(str);
	}
	
 
	
	/**
	 * List<String>转,分隔的字符串
	 * @return
	 */
	public static String join(List<String> list,String seperator){
		 if(notEmpty(list)){
			 StringBuffer sb = new StringBuffer();			    
		     for(int i=0; i<list.size(); i++){
		    	if(i > 0) {
		    		sb.append(seperator);
		    	}
		        sb.append(list.get(i));
		     }			    
		     return sb.toString();
		 }
		 return "";
	}
	
	/**
	 * 判断List是否不为空
	 */
	public static <T> boolean notEmpty(List<T> list){
		return !isEmpty(list);
	}
	
	/**
	 * 时间转换
	 * @param time	时间对象
	 * @param Format 转换格式
	 * @return
	 */
	public static String TimeForFormat(Timestamp time, String Format)
	{
	    String result = "";
	    if (time == null)
	    	return "";
	    try
	    {
	      SimpleDateFormat simpleFormat = new SimpleDateFormat(Format);
	      result = simpleFormat.format(time);
	    } catch (Exception e) {
	    	return "";
	    }
	    return result;
  	}
	public static String TimeForFormat(Date time, String Format)
	{
	    String result = "";
	    if (time == null)
	    	return "";
	    try
	    {
	      SimpleDateFormat simpleFormat = new SimpleDateFormat(Format);
	      result = simpleFormat.format(time);
	    } catch (Exception e) { 
	      return "";
	    }
	    return result;
  	}
}
