package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 课程包购买记录
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface BuyRecordService {

	public ResultObject<List<MyIndexCourseDto>> myIndexCourse(@RequestBody RequestObject<MyIndexCourseParameter> requestObject);


	/**
	 * 学生端-个人中心--首页--兑换记录
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<MyIndexBuyRecordDto>> myIndexBuyRecord(@RequestBody RequestObject<MyIndexBuyRecordParameter> requestObject);

	/**
	 * 消息記錄
	 * @param parameter
	 * @return
	 */
	public ResultObject<List<MyIndexMyintegralDetailDto>> myIndexMyintegralDetail(@RequestBody RequestObject<MyIndexMyintegralDetailParameter> parameter);

	/**
	 * 新增消费记录
	 * @param parameter
	 * @return
	 */
	public ResultObject<Void> insertBuyRecord(@RequestBody RequestObject<InsertBuyrecordParameter> parameter);
}

