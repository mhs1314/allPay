package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 课程答疑
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface AnswerService {

	/**
	 * 学生端-个人中心--首页--课程答疑
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<MyIndexCourseAnswerDto>> myIndexCourseAnswer(@RequestBody RequestObject<MyIndexCourseAnswerParameter> requestObject);

	/**
	 * app我的课程答疑
	 * @return
	 */
	public ResultObject<List<IndexMyAnswerDto>> indexMyAnswer(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * app我的课程答疑--答疑详情
	 * @return
	 */
	public ResultObject<IndexAnswerDetailsDto> indexAnswerDetails(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 我的课程答疑--答疑详情-追问回答
	 * @param requestObject
	 * @return
	 */
	public ResultObject<Void> indexAnswerDetailsAppendAnswer(@RequestBody RequestObject<IndexAnswerDetailsAppendAnswerParameter> requestObject);
	/**
	 * app教答疑列表
	 * @param param
	 * @return
	 */
	public ResultObject<List<AppSelectAnwerListDto>> appSelectAnwerList(@RequestBody RequestObject<UidAndTenantID> requestObject);
	
	/**
	 * app学生答疑追问
	 */
	public ResultObject<Void> appUpdateStudentAnswer(@RequestBody RequestObject<UidAndTenantID>requestObject);
	/**
	 * app老师答疑追答
	 */
	public ResultObject<Void> appUpdateTeacherAnswer(@RequestBody RequestObject<UidAndTenantID>requestObject);
	/**
	 * app老师答疑追答
	 */
	public ResultObject<Void> appInsertTeacherAnser(@RequestBody RequestObject<AppInsertTeacherAnswerParameter>requestObject);
}
