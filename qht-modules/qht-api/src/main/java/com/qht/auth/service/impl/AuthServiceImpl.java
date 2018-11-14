package com.qht.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.wxiaoqi.security.auth.common.util.jwt.JWTInfo;
import com.github.wxiaoqi.security.common.exception.auth.UserInvalidException;
import com.qht.auth.service.AuthService;
import com.qht.auth.util.JwtTokenUtil;
import com.qht.auth.util.QhtAuthenticationRequest;
import com.qht.biz.StudentBiz;
import com.qht.biz.TeacherBiz;
import com.qht.dto.StudentDto;
import com.qht.dto.TeacherDto;

/**
 * 权限验证
 * @author 草原狼
 * @date Nov 10, 2018 6:05:10 PM
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	private JwtTokenUtil jwtTokenUtil;
	
	private StudentBiz studentBiz;
    
	private TeacherBiz teacherBiz;
	
	@Autowired
    public AuthServiceImpl(
            JwtTokenUtil jwtTokenUtil,
            StudentBiz studentBiz,
            TeacherBiz teacherBiz) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.studentBiz = studentBiz;
        this.teacherBiz = teacherBiz;
    }
	
	@Override
	public String login(QhtAuthenticationRequest authenticationRequest) throws Exception {
		String account = authenticationRequest.getAccount();		
		String password = authenticationRequest.getPassword();
		authenticationRequest.setType(4);
		//3-教师,4-学生
		if(authenticationRequest.getType() == 3) {
			TeacherDto dto = teacherBiz.teacherLogin(account, password);
			if(dto == null) {
				throw new UserInvalidException("用户不存在或账户密码错误!");
			}
			if (!StringUtils.isEmpty(dto.getUid())) {
	            return jwtTokenUtil.generateToken(new JWTInfo(dto.getTenantId(), dto.getUid() + "", dto.getSchoolid()));
	        }
		}else if(authenticationRequest.getType() == 4) {
			StudentDto dto = studentBiz.studentLogin(account, password);
			if(dto == null) {
				throw new UserInvalidException("用户不存在或账户密码错误!");
			}
			if(!StringUtils.isEmpty(dto.getUid())) {
				return jwtTokenUtil.generateToken(new JWTInfo(dto.getNickname(), dto.getUid() + "", dto.getSchoolid()));
			}			
		}
		throw new UserInvalidException("用户不存在或账户密码错误!");
	}

	@Override
    public String refresh(String oldToken) throws Exception {
        return jwtTokenUtil.generateToken(jwtTokenUtil.getInfoFromToken(oldToken));
    }

	@Override
	public void validate(String token) throws Exception {
		jwtTokenUtil.getInfoFromToken(token);		
	}

}
