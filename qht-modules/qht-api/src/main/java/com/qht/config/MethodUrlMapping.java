package com.qht.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("methodUrlMapping")
public class MethodUrlMapping {
	// 被容器赋值
	private Map<String, String> methodUrlMapping = new HashMap<String, String>();

	public Map<String,String> getMethodUrlMapping() {
		return methodUrlMapping;
	}

	public void setMethodUrlMapping(Map<String,String> urlMethodMapping) {
		this.methodUrlMapping = urlMethodMapping;
	}
}
