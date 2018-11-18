package com.qht.auth.util;


import com.qht.context.EnvContextHandler;

/**
 * 请求上下文信息，如果需要获取学习ID可以找草原狼
 * @author 草原狼
 * @date Nov 15, 2018 5:56:08 PM
 */
public class RequestContextUtil {
	//获取用户ID
    public static String getUid() {    	
        return EnvContextHandler.getUid();
	}
	//获取运营商ID
	public static String getTenantId() {		
        return EnvContextHandler.getTenantId();
	}
	//获取昵称
	public static String getNickname() {		
        return EnvContextHandler.getNickname();
	}
	//获取姓名
	public static String getName() {		
        return EnvContextHandler.getName();
	}
	//获取账号
	public static String getAccount() {		
        return EnvContextHandler.getAccount();
	}
	
}
