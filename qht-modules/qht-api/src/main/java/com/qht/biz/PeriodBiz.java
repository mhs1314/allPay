package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Period;
import com.qht.mapper.PeriodMapper;
import com.qht.model.AppInsertPerIodParam;
import com.qht.model.CourseChapterModel;
import com.qht.model.IndexMyCourseTableModel;
import com.qht.model.IndexMyCourseTableParam;
import com.qht.model.PeriodDetailsModel;
import com.qht.model.SelectPeriodByTeacherIdModel;
import com.qht.model.UidAndTenantIDParam;

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
	
}