package com.qht.constant;

public class CommonConstants {
	
	public final static String RESOURCE_TYPE_MENU = "menu";
	public final static String RESOURCE_TYPE_BTN = "button";
	// 用户token异常
	public static final Integer EX_USER_INVALID_CODE = 40101;
	public static final Integer EX_USER_PASS_INVALID_CODE = 40001;
	// 客户端token异常
	public static final Integer EX_CLIENT_INVALID_CODE = 40301;
	public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
	public static final Integer EX_OTHER_CODE = 500;
	//用户ID
	public static final String CONTEXT_KEY_UID = "currentUId";
	//用户名
	public static final String CONTEXT_KEY_USERNAME = "currentUserName";
	//账号
	public static final String CONTEXT_KEY_ACCOUNT = "currentAccount";
	//TOken
	public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
	//运营商ID
	public static final String CONTEXT_KEY_TENANT_ID = "currentTenantId";
	//用户昵称
	public static final String CONTEXT_KEY_NICKNAME = "currentNickname";
	
	//public static final String JWT_KEY_USER_ID = "userId";
	//public static final String JWT_KEY_NAME = "name";
}
