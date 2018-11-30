package com.qht.auth.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import com.qht.ResultBuilder;
import com.qht.ResultObject;
import com.qht.auth.service.AuthService;
import com.qht.auth.util.QhtAuthenticationRequest;
import com.qht.dto.LoginResultDto;

import lombok.extern.slf4j.Slf4j;

/**
 * 青核桃业务登录（pc,mobile）
 * @author 草原狼
 * @date Nov 10, 2018 5:48:36 PM
 */
@RestController
@RequestMapping("jwt")
@Slf4j
public class JwtAuthController {
	@Value("${jwt.token-header}")
    private String tokenHeader;
	
	@Autowired
    private AuthService authService;
	
	@Autowired
    private HttpServletRequest request;
	
	@RequestMapping(value = "token", method = RequestMethod.POST)	
    public ResultObject<LoginResultDto> createAuthenticationToken(
            @RequestBody QhtAuthenticationRequest authenticationRequest) throws Exception {
		String requestId = authenticationRequest.getRequestId(); 
		try {
			LoginResultDto result = authService.login(authenticationRequest,request);           
	        return ResultBuilder.success(requestId, result);	
        }catch(Exception e) {
        	return ResultBuilder.error(requestId, "40001", "用户或密码错误");
        }               
    }	
	@RequestMapping(value = "refresh", method = RequestMethod.GET)
    public ObjectRestResponse<String> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        return new ObjectRestResponse<>().data(refreshedToken);
    }

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public ObjectRestResponse<?> verify(String token) throws Exception {
        authService.validate(token);
        return new ObjectRestResponse<>();
    }
	
}
