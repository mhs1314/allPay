package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 课程包
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface CoursePkgService {
	/**
	 * 获取首页的直播课程
	 * @return
	 */
	public ResultObject<List<LiveClassDto>> liveClass(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 获取首页免费课程
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<FreeClassDto>> freeClass(@RequestBody RequestObject<FreeClassParameter> requestObject);

	/**
	 * 获取首页试听课程列表
	 * @return
	 */
	public ResultObject<List<ListeningClassListDto>> listeningClassList(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 获取首页试听课程排行榜
	 * @return
	 */
	public ResultObject<List<ListeningClassRankingDto>> listeningClassRanking(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 课程详情--课程包简介
	 * @param requestObject
	 * @return
	 */
	public ResultObject<CourseIntroDto> courseIntro(@RequestBody RequestObject<CourseIntroParameter> requestObject);

	/**
	 * 课程列表
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<CourseListDto>> courseList(@RequestBody RequestObject<CourseListParameter >requestObject);

	/**
	 * 名师详情--全部课程
	 * @param uid
	 * @return
	 */
	public ResultObject<List<TeacherCourseDto>> teacherCourse(@RequestBody RequestObject<UidAndTenantID> uid);

	/**
	 * 近期课程
	 * @return
	 */
	public  ResultObject<List<IndexFutureCoruseDto>> indexFutureCoruse(@RequestBody RequestObject<UidAndTenantID> req);

	/**
	 *课程疑答
	 * @return
	 */
	public ResultObject<List<IndexAnswerDto>> indexAnswer(@RequestBody RequestObject<UidAndTenantID> req);

	/**
	 * 课程列表
	 * @param parameter
	 * @return
	 */
	public ResultObject<List<IndexCoruseListDto>> indexCoruseList(@RequestBody RequestObject<IndexCoruseListParameter> parameter);

	/**
	 * 学生端-个人中心--首页--兑换记录--课程详情
	 * @return
	 */
	public ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> myIndexBuyRecordCourseDetails(@RequestBody RequestObject<UidAndTenantID> req);

	/**
	 * 学生端-个人中心--首页--我的收藏列表
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<MyIndexMycollectDto>> myIndexMycollect(@RequestBody RequestObject<MyIndexMycollectParameter>requestObject);
}
