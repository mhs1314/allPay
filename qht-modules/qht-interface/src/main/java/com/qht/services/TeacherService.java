package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.LoginInfoDto;

/**
 * 教师
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface TeacherService {
	/**
	 * 根据教师登陆信息获取token
	 * @param rquest
	 * @return
	 */
	public ResultObject<String> login(RequestObject<LoginInfoDto> rquest);

}
