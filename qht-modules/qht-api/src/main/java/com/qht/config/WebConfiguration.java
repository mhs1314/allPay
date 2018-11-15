package com.qht.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.wxiaoqi.security.common.handler.GlobalExceptionHandler;
import com.qht.interceptor.EnvBaseContextHandler;

/**
 *
 * @author ace
 * @date 2017/9/8
 */
@Configuration("apiConfig")
@Primary
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	List<String> path = new ArrayList<String>();
    	//TODO需要在这个地方添加拦截信息，不然会不能获取token所携带的数据
    	path.add("/student/**");
        registry.addInterceptor(getAuthRestInterceptor()).addPathPatterns(path);
       
    }

    @Bean
    EnvBaseContextHandler getAuthRestInterceptor() {
        return new EnvBaseContextHandler();
    }

    
}
