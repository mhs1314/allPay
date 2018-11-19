package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.entity.Period;
import com.qht.model.AppInsertPerIodParam;
import com.qht.model.CourseChapterModel;
import com.qht.model.IndexMyCourseTableModel;
import com.qht.model.IndexMyCourseTableParam;
import com.qht.model.PeriodDetailsModel;
import com.qht.model.SelectPeriodByTeacherIdModel;
import com.qht.model.UidAndTenantIDParam;

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
}
