package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.CoursePkg;
import com.qht.mapper.CoursePkgMapper;
import com.qht.mapper.StudentMapper;
import com.qht.model.CourseChapterModel;
import com.qht.model.CoursePkgListModel;
import com.qht.model.IndexMyCourseDetailsModel;
import com.qht.model.UidAndTenantIDParam;

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
}