package com.qht.common.util;

import java.util.UUID;

public class IdGenUtil {
	
	public static String getUid(String type) {
		/**
		 * 获取主键
		 */
		return UUID.randomUUID().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getUid("order"));
	}
}
