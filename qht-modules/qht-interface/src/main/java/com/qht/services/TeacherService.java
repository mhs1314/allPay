package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.IndexMyCourseDto;
import com.qht.dto.IndexMyCourseParameter;
import com.qht.dto.LoginInfoDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
	public ResultObject<String> login(@RequestBody RequestObject<LoginInfoDto> rquest);

	public ResultObject<List<IndexMyCourseDto>> indexMyCourse(@RequestBody RequestObject<IndexMyCourseParameter> requestObject);

}
