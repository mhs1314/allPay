package com.qht.common.util;

import java.util.UUID;

public class IdGenUtil {
	
	public static String getUid(String type) {
		return UUID.randomUUID().toString();
	}

}
