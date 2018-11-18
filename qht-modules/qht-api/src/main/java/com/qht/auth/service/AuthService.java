package com.qht.auth.service;

import javax.servlet.http.HttpServletRequest;

import com.qht.auth.util.QhtAuthenticationRequest;
import com.qht.dto.LoginResultDto;

/**
 * 权限验证
 * @author 草原狼
 * @date Nov 10, 2018 6:04:16 PM
 */
public interface AuthService {
	LoginResultDto login(QhtAuthenticationRequest authenticationRequest,HttpServletRequest request) throws Exception;
	String refresh(String oldToken) throws Exception;
	void validate(String token) throws Exception;
}
