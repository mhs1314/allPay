package com.qht.biz;

import java.util.List;

import com.qht.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.CoursePkg;
import com.qht.mapper.CoursePkgMapper;
import com.qht.mapper.StudentMapper;

/**
 * 课程包
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class CoursePkgBiz extends BaseBiz<CoursePkgMapper,CoursePkg> {
	@Autowired
    private CoursePkgMapper coursePkgMapper;
	/**
	 * 查询所有课程包
	 * @return
	 */
	public List<CoursePkgListModel> courseTypeList(UidAndTenantIDParam ut){
		return coursePkgMapper.courseTypeList(ut);
	}
	/**
	 * 教师|端首页--我的课程--详情介绍
	 * @param param
	 * @return
	 */
	public IndexMyCourseDetailsModel selectIndexMyCourseDetails(UidAndTenantIDParam param) {
		
		return coursePkgMapper.selectIndexMyCourseDetails(param);
	}
	/**
	 * 课程详情--课程包体系y
	 * @param param
	 * @return
	 */
	public List<CourseChapterModel> selectCourseChapter(UidAndTenantIDParam param) {
		return coursePkgMapper.selectCourseChapter(param);
	}

	/**
	 * 添加课程包
	 * @param param
	 * @return
	 */
	public Integer indexAddLCourse(InsertCoursePkgParam param) {
		return coursePkgMapper.indexAddLCourse(param);
	}
	/**
	 * 修改课程包信息
	 */
	public Integer appUpdateCoursePkgByid(InsertCoursePkgParam param) {
		return coursePkgMapper.appUpdateCoursePkgByid(param);
	}
	/**
	 * 课程包章节课时信息
	 */
	public List<SelectPkgModel> selectPkgModel(UidAndTenantIDParam param){
		return coursePkgMapper.selectPkgChPer(param);
	}

	/**
	 * 查询修改课时章节的展示
	 * @param param
	 * @return
	 */
	public IndexMyCourseEditChapterAndPeriodModel selectIndexMyCourseEditChapterAndPeriodModel(UidAndTenantIDParam param) {

		return coursePkgMapper.selectIndexMyCourseEditChapterAndPeriodModel(param);
	}
	
	/**
	 * 通过学生id查询课程包    个人中心课程列表
	 * @param param
	 * @return
	 */
	
	public List<SelectPkgByStuIdModel> selectPkgByStuId(UidAndTenantIDParam param){
		return coursePkgMapper.selectPkgByStuId(param);
	}
	/**
	 * 课程包体系
	 */
	public List<SelectChaModel> selectCourseChapterByCuId(UidAndTenantIDParam param){
		return coursePkgMapper.selectCourseChapterByCuId(param);
	}

	/**
	 * 首页查询直播课程
	 *
	 * @param tenant_id
	 * @return
	 */

	public List<LiveClassModel> selectLiveClass(String tenant_id) {
		return coursePkgMapper.selectLiveClass(tenant_id);
	}

	/**
	 * 查询首页的免费课程
	 * @return
	 */

	public List<FreeClassModel> selectFreeClass(FreeClassParam data) {
		return coursePkgMapper.selectFreeClass(data);
	}

	/**
	 * 查询首页试听列表
	 * @param tenant_id
	 * @return
	 */

	public List<ListeningClassListModel> selectListeningClassList(String tenant_id) {
		return coursePkgMapper.selectListeningClassList(tenant_id);
	}

	/**
	 * 查询首页试听排行榜
	 * @param tenant_id
	 * @return
	 */

	public List<ListeningClassRankingModel> selectListeningClassRanking(String tenant_id) {
		return coursePkgMapper.selectListeningClassRanking(tenant_id);
	}

	/**
	 * 查询学生课程详情-课程包简介
	 * @param uid
	 * @param tenant_id
	 * @return
	 */

	public CourseIntroModel selectCourseIntro(String uid, String tenant_id) {

		return coursePkgMapper.selectCourseIntro(uid,tenant_id);
	}

	/**
	 * 课程列表
	 * @param data
	 * @return
	 */

	public List<CourseListModel> selectCourseList(CourseListParam data) {
		return coursePkgMapper.selectCourseList(data);
	}

	/**
	 * 名师详情--全部课程
	 * @param uid
	 * @param tenant_id
	 * @return
	 */
	public List<TeacherCourseModel> selectTeacherCourse(String uid, String tenant_id) {
		return coursePkgMapper.selectTeacherCourse(uid,tenant_id);
	}

	/**
	 * 近期合同
	 * @param uid
	 * @param tenant_id
	 * @return
	 */

	public List<IndexFutureCoruseModel> indexFutureCoruse(String uid,String tenant_id){
		return coursePkgMapper.indexFutureCoruse(uid,tenant_id);
	}

	/**
	 * 课程疑答
	 * @param tenant_id
	 * @return
	 */

	public  List<IndexAnswerModel> indexAnswer(String tenant_id){
		return coursePkgMapper.indexAnswer(tenant_id);
	}

	/**
	 * 课程列表
	 * @param parameter
	 * @return
	 */

	public   List<IndexCoruseListModel> indexCoruseList(IndexCoruseListParam parameter){
		return coursePkgMapper.indexCoruseList(parameter);
	}

	/**
	 * 学生端-个人中心--首页--兑换记录--课程详情
	 * @param uid
	 * @return
	 */

	public List<MyIndexBuyRecordCourseDetailsModel> selectMyIndexBuyRecordDetails(String uid) {
		return coursePkgMapper.selectMyIndexBuyRecordDetails(uid);
	}

	/**
	 *学生端-个人中心--首页--我的收藏列表
	 * @param data
	 * @return
	 */

	public List<MyIndexMycollectModel> selectMyIndexMycollect(MyIndexMycollectParam data) {
		return coursePkgMapper.selectMyIndexMycollect(data);
	}

	public List<IndexMyCourseModel> selectIndexMyCourseDto(IndexMyCourseParam param) {
		return coursePkgMapper.selectIndexMyCourseDto(param);
	}

	/**
	 * 教师端首页--我的课程包
	 * @param data
	 * @return
	 */
	public List<IndexMyCourseListModel> selectIndexMyCourseList(IndexMyCourseListParam data) {
		return coursePkgMapper.selectIndexMyCourseList(data);
	}
}