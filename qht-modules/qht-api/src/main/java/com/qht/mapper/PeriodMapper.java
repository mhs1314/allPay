package com.qht.mapper;

import java.util.List;

import com.qht.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qht.entity.Period;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课时
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface PeriodMapper extends Mapper<Period> {
	/**
	 * 学生在线课程的课表
	 * @param param
	 * @return
	 */
	List<IndexMyCourseTableModel>indexMycourseTable(IndexMyCourseTableParam param);
	/**
	 * 通过章节id查课时
	 * @param param
	 * @return
	 */
	List<CourseChapterModel> selectPeriodByid(UidAndTenantIDParam param);
	/**
	 * 新增课时
	 */
	Integer insertPerIod(AppInsertPerIodParam param);
	/**
	 * 根据老师查询它下面的所有课时
	 */
	List<SelectPeriodByTeacherIdModel> selectPeriodByTeachId(UidAndTenantIDParam param);
	/**
	 * 课时详情
	 */
	PeriodDetailsModel selectPeriodDetails(UidAndTenantIDParam param);

	/**
	 * 学生端-个人中心--首页--我的课时详情介绍
	 * @param param
	 * @return
	 */
	MyIndexCourseDetailsModel selectMyIndexCourseDetails(UidAndTenantIDParam param);

	/**
	 * 学生端-个人中心--首页--兑换记录--课程回看
	 * @param data
	 * @return
	 */

	List<MyIndexBuyRecordCourseBackModel> selectMyIndexBuyRecordCourseBack(MyIndexBuyRecordCourseBackParam data);

	/**
	 * 学生端-个人中心--首页--我的课程详情介绍
	 * @param uid
	 * @param tenant_id
	 * @return
	 */

	List<IndexCourseDetailsModel> selectIndexCourseDetails(@Param("uid") String uid, @Param("tenant_id") String tenant_id);
}
