package com.qht.config;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component("urlMethodMapping")
public class UrlMethodMapping {
	//被容器赋值
	private Map<String,Method> urlMethodMapping = new HashMap<String,Method>();

	public Map<String, Method> getUrlMethodMapping() {
		return urlMethodMapping;
	}

	public void setUrlMethodMapping(Map<String, Method> urlMethodMapping) {
		this.urlMethodMapping = urlMethodMapping;
	}
	
}
