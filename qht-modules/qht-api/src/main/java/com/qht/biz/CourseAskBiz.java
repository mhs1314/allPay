//package com.qht.biz;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.github.wxiaoqi.security.common.biz.BaseBiz;
//import com.qht.entity.CourseAsk;
//import com.qht.mapper.CourseAskMapper;
//import com.qht.model.AppInsertStudentAskParam;
//
///**
// * 课程提问
// *
// * @author yangtonggan
// * @email 2466607841@qq.com
// * @date 2018-11-05 18:55:41
// */
//@Service
//public class CourseAskBiz extends BaseBiz<CourseAskMapper,CourseAsk> {
//	@Autowired
//	private CourseAskMapper courseAskMapper;
//	/**
//	 * app学生对课时提问
//	 */
//	public Integer appInserStudentAsk(AppInsertStudentAskParam param) {
//		return courseAskMapper.appInserStudentAsk(param);
//	}
//}