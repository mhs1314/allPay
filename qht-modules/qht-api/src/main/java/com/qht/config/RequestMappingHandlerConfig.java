package com.qht.config;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author 草原狼
 * 2018年9月3日
 */
@Configuration
public class RequestMappingHandlerConfig implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger log = LoggerFactory.getLogger(RequestMappingHandlerConfig.class);
	
	@Resource(name = "urlMethodMapping")
	private UrlMethodMapping urlMethodMapping;
	
	@Resource(name = "methodUrlMapping")
	private MethodUrlMapping methodUrlMapping;

	@Bean(name = "requestMappingHandlerMapping")
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
		return mapping;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("=======================ContextRefreshedEvent======================================");
		ApplicationContext appContext = event.getApplicationContext();
		Map<String, HandlerMapping> allRequestMappings = BeanFactoryUtils.beansOfTypeIncludingAncestors(appContext,
				HandlerMapping.class, true, false);
		for (HandlerMapping handlerMapping : allRequestMappings.values()) {
			if (handlerMapping instanceof RequestMappingHandlerMapping) {
				Map<RequestMappingInfo, HandlerMethod> map = ((RequestMappingHandlerMapping) handlerMapping)
						.getHandlerMethods();
				for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
					RequestMappingInfo info = m.getKey();
					HandlerMethod method = m.getValue();
					info.getPatternsCondition().toString();
					method.getMethod().getDeclaringClass();
					method.getMethod().getName();
					Set<String> set = info.getPatternsCondition().getPatterns();
					String url = set.iterator().next();	
					
					//log.info(url+"===>"+method.getMethod());
					//urlMethodMapping.getUrlMethodMapping().put(url, method.getMethod());
					log.info(method.getMethod().getName()+"===>"+url);
					methodUrlMapping.getMethodUrlMapping().put(method.getMethod().getName(), url);
				}

			}
		}
		
	}

}
