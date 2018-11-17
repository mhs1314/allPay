package com.qht.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * javaBean工具类
 * @author yangtonggan
 * @date 2016-12-26
 */
public class BeanUtil {
	private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);
	
	/**
	 * 复制list到目标list中,实体类可以不一致，只拷贝属性值
	 * @param target
	 * @param sourceList
	 */
	public static <Target,Source> List<Target> copyList(Class<Target> target,List<Source> sourceList) {
		List<Target> list = new ArrayList<Target>();
		if(sourceList == null || sourceList.size() == 0) {
			return list;
		}
		try {
			for(Source source : sourceList) {
				Target targetObj = target.newInstance();
				copyFields(targetObj,source);
				list.add(targetObj);
			}			
		} catch (Exception e) {
			 logger.error("复制成员变量出错！", e);
	         throw new RuntimeException(e);
		} 
		return list;
	}
	/**
     * 复制所有成员变量
     * target目标对象
     * source 源对象
     */
    public static void copyFields(Object target,Object source) {
    	if(target == null || source == null) {
    		return;
    	}
        try {
            for (Field field : source.getClass().getDeclaredFields()) {
                // 若不为 static 成员变量，则进行复制操作
                if (!Modifier.isStatic(field.getModifiers())) {                    
                	field.setAccessible(true); // 可操作私有成员变量                                     
                    Object value = getPropertyValue(source,field.getName());
                    setPropertyValue(target,field.getName(),value);
                    
                }
            }
        } catch (Exception e) {
            logger.error("复制成员变量出错！", e);
            throw new RuntimeException(e);
        }
    }
    
	/**
	 * 得到某个对象的公共属性 
	 * @param owner
	 * @param fieldName
	 * @return 该属性对象
	 * @throws Exception
	 */	
	public static Object getPropertyValue(Object owner, String fieldName) {
		Field field;
		Object property = null;
		try {
			field = owner.getClass().getDeclaredField(fieldName);
			if(field != null){
				boolean flag = field.isAccessible();
				field.setAccessible(true);
				property = field.get(owner);
				field.setAccessible(flag);
			}			
		} catch (Exception e) {			
			logger.debug(e.getMessage(), e);
		}	
		return property;
	}
	
	/**
	 * 获取get方法值
	 * @param owner
	 * @param fieldName
	 * @return
	 */
	public static Object getMethodValue(Object owner, String fieldName){
		try{
			Method m = GetSetMethodUtil.obtainGetMethod(owner.getClass(), fieldName);
			if(m != null){
				return m.invoke(owner);
			}						
		}catch(Exception e){
			logger.debug(e.getMessage(), e);			
		}
		return null;
	}
	
	/**
	 * 设置对象属性值
	 * @param owner      当前对象
	 * @param fieldName  属性名
	 * @param vlaue      属性值
	 */
	public static void setPropertyValue(Object owner, String fieldName,Object value) {
		try {
			Field f = setFieldValue(owner,fieldName,value);
			if(f == null){
				setMethodValue(owner,fieldName,value);
			}					
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}	
	}
	
	/**
	 * 把数据设置到字段中去
	 */
	private static Field setFieldValue(Object owner, String fieldName,Object value){
		try{
			Field field = owner.getClass().getDeclaredField(fieldName);
			if(field != null){
				boolean flag = field.isAccessible();
				field.setAccessible(true);
				field.set(owner, value);
				field.setAccessible(flag);
				return field;
			}			
		}catch(Exception e){			
			logger.debug(e.getMessage(), e);
		}
		return null;
	}
	
	/**
	 * 调用setXX方法设置数据
	 */
	private static void setMethodValue(Object owner, String fieldName,Object value){
		try{
			Method m = GetSetMethodUtil.obtainSetMethod(owner.getClass(), fieldName);
			if(m != null){
				m.invoke(owner, value);
			}						
		}catch(Exception e){
			logger.debug(e.getMessage(), e);
		}		
	}
	
	
	
}

