package com.qht.context;


import java.util.HashMap;
import java.util.Map;


import com.github.wxiaoqi.security.common.util.StringHelper;
import com.qht.constant.CommonConstants;

public class EnvContextHandler {
	public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
	
	private static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

	private static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
    
    //获取用户ID
    public static String getUid() {
    	Object value = get(CommonConstants.CONTEXT_KEY_UID);
        return StringHelper.getObjectValue(value);
	}
	public static void setUid(String uid) {
		set(CommonConstants.CONTEXT_KEY_UID,uid);
	}
	public static String getTenantId() {
		Object value = get(CommonConstants.CONTEXT_KEY_TENANT_ID);
        return StringHelper.getObjectValue(value);
	}
	public static void setTenantId(String tenantId) {
		set(CommonConstants.CONTEXT_KEY_TENANT_ID,tenantId);
	}
	public static String getNickname() {
		Object value = get(CommonConstants.CONTEXT_KEY_NICKNAME);
        return StringHelper.getObjectValue(value);
	}
	public static void setNickname(String nickname) {
		set(CommonConstants.CONTEXT_KEY_NICKNAME,nickname);
	}
	public static String getName() {
		Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
        return StringHelper.getObjectValue(value);
	}
	public static void setName(String name) {
		set(CommonConstants.CONTEXT_KEY_USERNAME,name);
	}
	public static String getAccount() {
		Object value = get(CommonConstants.CONTEXT_KEY_ACCOUNT);
        return StringHelper.getObjectValue(value);
	}
	public static void setAccount(String account) {
		set(CommonConstants.CONTEXT_KEY_ACCOUNT,account);
	}  

    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void remove(){
        threadLocal.remove();
    }
        
}
