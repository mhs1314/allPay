/**
 * 
 */
package com.github.wxiaoqi.security.gate.v2.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author pqbaojian
 * @date 2018年7月13日 上午2:20:24
 */
@Configuration  	
public class CorsConfig  extends WebMvcConfigurerAdapter {
	@Override  
    public void addCorsMappings(CorsRegistry registry) {  
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins(
                "https://edu.qw1000.cn",
                "https://eduqpi.qw1000.cn"
        )
                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
                .maxAge(3600);  
    }





}
