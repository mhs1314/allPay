package com.qht.common.util;

import java.util.UUID;

public class IdGenUtil {
	
	public static String getUid(String type) {
		String url="http://139.159.198.250:8768/uid/idLeafKey";
		return UUID.randomUUID().toString();
	}

}
