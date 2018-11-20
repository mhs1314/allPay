package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 课时
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface PeriodService {

	/**
	 * 学生端-个人中心--首页--我的课时详情介绍
	 * @param requestObject
	 * @return
	 */
	public ResultObject<MyIndexCourseDetailsDto> myIndexCourseDetails(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 学生端-个人中心--首页--兑换记录--课程回看
	 * @return
	 */
	public ResultObject<List<MyIndexBuyRecordCourseBackDto>> myIndexBuyRecordCourseBack(@RequestBody RequestObject<MyIndexBuyRecordCourseBackParameter> requestObject);

	/**
	 * 学生端-个人中心--首页--我的课程详情介绍
	 * @param req
	 * @return
	 */
	public ResultObject<List<IndexCourseDetailsDto>> indexCourseDetails(@RequestBody RequestObject<UidAndTenantID> req);

}
