package com.qht.mapper;

import java.util.List;

import com.qht.dto.*;
import com.qht.dto.CourseChapterDto;
import com.qht.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qht.entity.CoursePkg;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程包
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface CoursePkgMapper extends Mapper<CoursePkg> {
	/**
	 * 查询所有课程包
	 * @return
	 */
	List<CoursePkgListModel>courseTypeList(UidAndTenantIDParam ut);
	/**
	 * 教师|端首页--我的课程--详情介绍
	 * @param param
	 * @return
	 */
	IndexMyCourseDetailsModel selectIndexMyCourseDetails(UidAndTenantIDParam param);
	/**
	 * 课程详情--课程包体系y
	 * @param param
	 * @return
	 */
	List<CourseChapterModel> selectCourseChapter(UidAndTenantIDParam param);

	/**
	 * 添加课程包
	 * @param param
	 * @return
	 */
	Integer indexAddLCourse(InsertCoursePkgParam param);
	/**
	 * 修改课程包信息
	 */
	Integer appUpdateCoursePkgByid(InsertCoursePkgParam param);
	/**
	 * 课程包章节课时信息
	 */
	List<SelectPkgModel> selectPkgChPer(UidAndTenantIDParam param);

	/**
	 * 查询--修改章节课时的展示
	 * @param param
	 * @return
	 */
	IndexMyCourseEditChapterAndPeriodDto selectIndexMyCourseEditChapterAndPeriodModel(UidAndTenantIDParam param);
	/**
	 * 通过学生id查询课程包    个人中心课程列表
	 * @param param
	 * @return
	 */
	
	List<SelectPkgByStuIdModel> selectPkgByStuId(UidAndTenantIDParam param);
	
	/**
	 * 课程包体系
	 */
	List<SelectChaModel> selectCourseChapterByCuId(UidAndTenantIDParam param);

	/**
	 * 通过运营id查询首页直播课程
	 * @param tenant_id
	 * @return
	 */
	List<LiveClassModel> selectLiveClass(String tenant_id);

	/**
	 * 通过pkg_subject_id，pkg_grade_id，tenant_id查询首页免费课程
	 * @return
	 */
	List<FreeClassModel> selectFreeClass(FreeClassParam data);

	/**
	 * 通过运营id查询首页试听列表
	 * @param tenant_id
	 * @return
	 */
	List<ListeningClassListModel> selectListeningClassList(String tenant_id);

	/**
	 * 通过运营id查询首页试听排行榜
	 * @param tenant_id
	 * @return
	 */
	List<ListeningClassRankingModel> selectListeningClassRanking(String tenant_id);

	/**
	 * 查询学生课程详情-课程包简介
	 * @param uid
	 * @param tenant_id
	 * @return
	 */
	CourseIntroModel selectCourseIntro(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

	/**
	 * 课程列表
	 * @param data
	 * @return
	 */
	List<CourseListModel> selectCourseList(CourseListParam data);

	/**
	 * 名师详情--全部课程
	 * @param uid
	 * @param tenant_id
	 * @return
	 */

	List<TeacherCourseModel> selectTeacherCourse(@Param("uid")String uid, @Param("tenant_id") String tenant_id);

	/**
	 * 近期合同
	 * @param uid
	 * @param tenant_id
	 * @return
	 */

	List<IndexFutureCoruseModel> indexFutureCoruse(@Param("uid")String uid,@Param("tenant_id")String tenant_id);

	/**
	 * 课程疑答
	 * @param tenant_id
	 * @return
	 */

	List<IndexAnswerModel> indexAnswer(String tenant_id);

	/**
	 * 课程列表
	 * @param parameter
	 * @return
	 */

	List<IndexCoruseListModel> indexCoruseList(IndexCoruseListParam parameter);

	/**
	 * 学生端-个人中心--首页--兑换记录--课程详情
	 * @param uid
	 * @return
	 */

	List<MyIndexBuyRecordCourseDetailsModel> selectMyIndexBuyRecordDetails(String uid);

	/**
	 * 学生端-个人中心--首页--我的收藏列表
	 * @param data
	 * @return
	 */

	List<MyIndexMycollectModel> selectMyIndexMycollect(MyIndexMycollectParam data);

	List<IndexMyCourseModel> selectIndexMyCourseDto(IndexMyCourseParam param);

	List<IndexMyCourseModel> selectTeaIndexMyCourseDto(IndexMyCourseParam param);

	/**
	 * 教师端首页--我的课程包
	 * @param data
	 * @return
	 */
	List<IndexMyCourseListModel> selectIndexMyCourseList(IndexMyCourseListParam data);

	/**
	 * 课程包评论
	 */
	List<SelectCoursePkgPingModel> selectCoursePkgPing(UidAndTenantIDParam param);
	/**
	 * 差评
	 */
	Integer countMin(String uid);
	/**
	 * 中评
	 */
	Integer countbad(String uid);
	/**
	 * 好评
	 */
	Integer countGood(String uid);
	/**
	 * 全部
	 */
	Integer count(String uid);
	/**
	 * 课程报价格
	 */
	Integer selectTotalPrice(String uid);
	/**
	 * app查看课程包简介
	 */
	SelectCorseInfoJJModel selectCoursePkgInfoJJ(UidAndTenantIDParam param);

}
