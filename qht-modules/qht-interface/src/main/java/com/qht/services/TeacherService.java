package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;
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

	/**
	 * 教师端首页--我的课程包
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexMyCourseDto>> indexMyCourse(@RequestBody RequestObject<IndexMyCourseParameter> requestObject);

	/**
	 * 教师端首页--我的课程包
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexMyCourseListDto>> indexMyCourseList(@RequestBody RequestObject<IndexMyCourseListParameter> requestObject);

	/**
	 * 教师端首页--添加录播课程包
	 * @param requestObject
	 * @return
	 */
	public ResultObject<Void> indexAddLcourse(@RequestBody RequestObject<IndexAddLcourseParameter> requestObject);
	
	/**
	 * 教师端首页--添加直播课程包
	 * @param requestObject
	 * @return
	 */
	public ResultObject<Void> indexAddZcourse(@RequestBody RequestObject<IndexAddZcourseParameter> requestObject);
	
	/**
	 * 教师端首页--课程答疑列表
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexCourseAnswerDto>> indexCourseAnswer(@RequestBody RequestObject<IndexCourseAnswerParameter> requestObject);
	
	/**
	 * 教师端首页--我的消息
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexMessageDto>> indexMessage(@RequestBody RequestObject<IndexMessageParameter> requestObject);
	/**
	 * 教师端首页--删除我的消息
	 * @param requestObject
	 * @return
	 */
	public ResultObject<Void> indexDelMessage(@RequestBody RequestObject<UidAndTenantID> requestObject);
	/**
	 * 教师端首页--我的消息--查看详情
	 * @param requestObject
	 * @return
	 */
	public ResultObject<IndexMessageDto> indexDelMessageDetails(@RequestBody RequestObject<UidAndTenantID> requestObject);
	
	/**
	 * 教师|端首页--我的课程--详情介绍
	 * @param requestObject
	 * @return
	 */
	public ResultObject<IndexMyCourseDetailsDto> indexMyCourseDetails(@RequestBody RequestObject<UidAndTenantID> requestObject);
	
	/**
	 * 课程详情-课程包体系y
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<CourseChapterDto>> courseChapter(@RequestBody RequestObject<UidAndTenantID> requestObject);



	

}
