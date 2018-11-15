package com.qht.auth.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.wxiaoqi.security.auth.common.util.jwt.JWTInfo;
import com.github.wxiaoqi.security.common.exception.auth.UserInvalidException;
import com.qht.auth.service.AuthService;
import com.qht.auth.util.QhtAuthenticationRequest;
import com.qht.auth.util.QhtJWTInfo;
import com.qht.auth.util.QhtJwtTokenUtil;
import com.qht.biz.StudentBiz;
import com.qht.biz.TeacherBiz;
import com.qht.dto.LoginResultDto;
import com.qht.dto.StudentDto;
import com.qht.dto.StudentLoginResultDto;
import com.qht.dto.TeacherDto;
import com.qht.dto.TeacherLoginResultDto;

/**
 * 权限验证
 * @author 草原狼
 * @date Nov 10, 2018 6:05:10 PM
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	private QhtJwtTokenUtil jwtTokenUtil;
	
	private StudentBiz studentBiz;
    
	private TeacherBiz teacherBiz;
	
	@Autowired
    public AuthServiceImpl(
    		QhtJwtTokenUtil jwtTokenUtil,
            StudentBiz studentBiz,
            TeacherBiz teacherBiz) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.studentBiz = studentBiz;
        this.teacherBiz = teacherBiz;
    }
	
	@Override
	public LoginResultDto login(QhtAuthenticationRequest authenticationRequest,HttpServletRequest request) throws Exception {
		String account = authenticationRequest.getAccount();		
		String password = authenticationRequest.getPassword();
		//authenticationRequest.setType(4);
		//3-教师,4-学生
		if(authenticationRequest.getType() == 3) {
			TeacherDto dto = teacherBiz.teacherLogin(account, password);
			if(dto == null) {
				throw new UserInvalidException("用户不存在或账户密码错误!");
			}
			request.getSession().setAttribute("user_session_key",dto);
			if (!StringUtils.isEmpty(dto.getUid())) {
				TeacherLoginResultDto result = new TeacherLoginResultDto();
				String token = jwtTokenUtil.generateToken(toQhtJWTInfo(dto));				
				result.setToken(token);
				result.setNickname(dto.getNickname());
				result.setSchoolId(dto.getSchoolid());
				result.setTenantId(dto.getTenant_id());
				result.setUid(dto.getUid());
	            //return jwtTokenUtil.generateToken(new JWTInfo(dto.getTenantId(), dto.getUid() + "", dto.getSchoolid()));
				return result;
	        }
		}else if(authenticationRequest.getType() == 4) {
			StudentDto dto = studentBiz.studentLogin(account, password);
			if(dto == null) {
				throw new UserInvalidException("用户不存在或账户密码错误!");
			}
			request.getSession().setAttribute("user_session_key",dto);
			if(!StringUtils.isEmpty(dto.getUid())) {
				//return jwtTokenUtil.generateToken(new JWTInfo(dto.getTenantId(), dto.getUid() + "", dto.getSchoolid()));
				StudentLoginResultDto result = new StudentLoginResultDto();
				String token = jwtTokenUtil.generateToken(toQhtJWTInfo(dto));
				result.setToken(token);
				result.setNickname(dto.getNickname());
				result.setSchoolId(dto.getSchoolid());
				result.setTenantId(dto.getTenant_id());
				result.setUid(dto.getUid());
	            //return jwtTokenUtil.generateToken(new JWTInfo(dto.getTenantId(), dto.getUid() + "", dto.getSchoolid()));
				return result;
			}			
		}
		throw new UserInvalidException("用户不存在或账户密码错误!");
	}
	//教师转token信息
	private QhtJWTInfo toQhtJWTInfo(TeacherDto dto) {
		if(dto == null) {
			throw new RuntimeException("教师信息为空，不能生成token");
		}
		String uid = dto.getUid();
		String tenantId = dto.getTenant_id();
		String nickname = dto.getNickname();
		String name = dto.getName();
		String account = dto.getAccount();
		QhtJWTInfo inf = new QhtJWTInfo(uid, tenantId, nickname, name, account);		
		return inf;
	}
	//学生转token信息
	private QhtJWTInfo toQhtJWTInfo(StudentDto dto) {
		if(dto == null) {
			throw new RuntimeException("学生信息为空，不能生成token");
		}
		String uid = dto.getUid();
		String tenantId = dto.getTenant_id();
		String nickname = dto.getNickname();
		String name = dto.getName();
		String account = dto.getAccount();
		QhtJWTInfo inf = new QhtJWTInfo(uid, tenantId, nickname, name, account);		
		return inf;
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
