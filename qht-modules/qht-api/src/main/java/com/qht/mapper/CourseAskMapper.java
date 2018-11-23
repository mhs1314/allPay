package com.qht.mapper;

import org.springframework.stereotype.Repository;

import com.qht.entity.CourseAsk;
import com.qht.model.AppInsertStudentAskParam;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程提问
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface CourseAskMapper extends Mapper<CourseAsk> {
	/**
	 * app学生对课时提问
	 */
	Integer appInserStudentAsk(AppInsertStudentAskParam param);

}
