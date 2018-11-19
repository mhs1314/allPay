package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;

import org.springframework.web.bind.annotation.RequestBody;

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
	 * 
	 * @param rquest
	 * @return
	 */
	public ResultObject<String> login(@RequestBody RequestObject<LoginInfoDto> rquest);

	/**
	 * 教师端首页--我的课程包
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexMyCourseDto>> indexMyCourse(
			@RequestBody RequestObject<IndexMyCourseParameter> requestObject);

	/**
	 * 教师端首页--我的课程包
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexMyCourseListDto>> indexMyCourseList(
			@RequestBody RequestObject<IndexMyCourseListParameter> requestObject);

	/**
	 * 教师端首页--课程答疑列表
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexCourseAnswerDto>> indexCourseAnswer(
			@RequestBody RequestObject<IndexCourseAnswerParameter> requestObject);

	/**
	 * 教师端首页--我的消息
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<IndexMessageDto>> indexMessage(
			@RequestBody RequestObject<IndexMessageParameter> requestObject);

	/**
	 * 教师端首页--删除我的消息
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<Void> indexDelMessage(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 教师端首页--我的消息--查看详情
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<IndexMessageDto> indexDelMessageDetails(
			@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 教师|端首页--我的课程--详情介绍
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<IndexMyCourseDetailsDto> indexMyCourseDetails(
			@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 课程详情-课程包体系y
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<CourseChapterDto>> courseChapter(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * app添加录播课程包
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<UidAndTenantID> appIndexAddLCourse(
			@RequestBody RequestObject<InsertCoursePkgParameter> requestObject);

	/**
	 * app添加章节
	 */
	public ResultObject<Void> appInsertChapter(@RequestBody RequestObject<AppInsertChapterParameter> requestObject);

	/**
	 * 修改课程包
	 */
	public ResultObject<Void> appUpdateCoursePkgByid(
			@RequestBody RequestObject<InsertCoursePkgParameter> requestObject);

	/**
	 * 课程包章节课时信息
	 */
	public ResultObject<List<SelectPkgDto>> selectPkgDto(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 课程包id查章节
	 */
	public ResultObject<List<CourseChapterDto>> selectChapterByid(
			@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 章节id查课时
	 */
	public ResultObject<List<CourseChapterDto>> selectPeriodByid(
			@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 添加课时
	 */
	public ResultObject<Void> insertPerIod(@RequestBody RequestObject<AppInsertPerIodParameter> requestObject);

	/**
	 * 根据老师id和直播状态查询课时
	 */
	public ResultObject<List<SelectPeriodByTeacherIdDto>> selectPeriodByTeachId(
			@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 查看课时详情
	 */
	public ResultObject<PeriodDetailsDto> selectPeriodDetails(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 查看课时详情
	 */
	public ResultObject<AppSelectTeacherByidDto> selectTeacherByid(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 编辑课时章节的展示
	 * @param requestObject
	 * @return
	 */
	public ResultObject<IndexMyCourseEditChapterAndPeriodDto> indexMyCourseEditChapterAndPeriodDto(@RequestBody RequestObject<UidAndTenantID> requestObject);

}
