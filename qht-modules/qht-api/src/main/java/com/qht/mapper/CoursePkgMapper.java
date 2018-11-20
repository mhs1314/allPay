package com.qht.mapper;

import java.util.List;

import com.qht.model.*;
import org.springframework.stereotype.Repository;

import com.qht.dto.AppStudentParameter;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.UidAndTenantID;
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
	IndexMyCourseEditChapterAndPeriodModel selectIndexMyCourseEditChapterAndPeriodModel(UidAndTenantIDParam param);
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
}
