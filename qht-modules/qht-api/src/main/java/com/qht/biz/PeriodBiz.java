package com.qht.biz;

import java.util.List;

import com.qht.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Period;
import com.qht.mapper.PeriodMapper;

/**
 * 课时
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class PeriodBiz extends BaseBiz<PeriodMapper,Period> {
	@Autowired
	private PeriodMapper periodMapper;
	/**
	 * 课时
	 * 
	 * @author yangtonggan
	 * @email 2466607841@qq.com
	 * @date 2018-11-05 18:55:41
	 * @Mapper
	 */
	public List<IndexMyCourseTableModel>indexMycourseTable(IndexMyCourseTableParam param){
		return periodMapper.indexMycourseTable(param);
	}
	/**
	 * 通过章节id查课时
	 * @param param
	 * @return
	 */
	public List<CourseChapterModel> selectPeriodByid(UidAndTenantIDParam param){
		return periodMapper.selectPeriodByid(param);
	}
	/**
	 * 新增课时
	 */
	public Integer insertPerIod(AppInsertPerIodParam param) {
		return periodMapper.insertPerIod(param);
	}
	/**
	 * 根据老师查询它下面的所有课时
	 */
	public List<SelectPeriodByTeacherIdModel> selectPeriodByTeachId(UidAndTenantIDParam param){
		return periodMapper.selectPeriodByTeachId(param);
	}
	/**
	 * 课时详情
	 */
	public PeriodDetailsModel selectPeriodDetails(UidAndTenantIDParam param) {
		return periodMapper.selectPeriodDetails(param);
	}

	/**
	 * 学生端-个人中心--首页--我的课时详情介绍
	 * @param param
	 * @return
	 */
	public MyIndexCourseDetailsModel selectMyIndexCourseDetails(UidAndTenantIDParam param) {
		return periodMapper.selectMyIndexCourseDetails(param);
	}
	/**
	 * 学生端-个人中心--首页--兑换记录--课程回看
	 * @param data
	 * @return
	 */

	public List<MyIndexBuyRecordCourseBackModel> selectMyIndexBuyRecordCourseBack(MyIndexBuyRecordCourseBackParam data) {

		return periodMapper.selectMyIndexBuyRecordCourseBack(data);
	}

	/**
	 * 学生端-个人中心--首页--我的课程详情介绍
	 * @param uid
	 * @param tenant_id
	 * @return
	 */

	public List<IndexCourseDetailsModel> selectIndexCourseDetails(String uid, String tenant_id) {
		return periodMapper.selectIndexCourseDetails(uid,tenant_id);
	}
	
}