package com.qht.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.github.wxiaoqi.security.common.context.BaseContextHandler;
import com.qht.auth.configuration.UserConfiguration;
import com.qht.auth.util.QhtJWTInfo;
import com.qht.auth.util.QhtJwtTokenUtil;
import com.qht.context.EnvContextHandler;

public class EnvBaseContextHandler extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(EnvBaseContextHandler.class);
    @Autowired
    private QhtJwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserConfiguration userConfiguration;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // HandlerMethod handlerMethod = (HandlerMethod) handler;
        String token = request.getHeader(userConfiguration.getUserTokenHeader());
        QhtJWTInfo infoFromToken = jwtTokenUtil.getInfoFromToken(token);
      
        EnvContextHandler.setAccount(infoFromToken.getAccount());
        EnvContextHandler.setName(infoFromToken.getName());
        EnvContextHandler.setNickname(infoFromToken.getNickname());
        EnvContextHandler.setTenantId(infoFromToken.getTenantId());
        EnvContextHandler.setUid(infoFromToken.getUid());
        return true;
        //return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
