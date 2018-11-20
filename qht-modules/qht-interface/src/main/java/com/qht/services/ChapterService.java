package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.CourseIntroParameter;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

/**
 * 课程章节
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface ChapterService {

	/**
	 * 课程详情--课程包体系
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<CourseChapterDto>> courseChapter(@RequestBody RequestObject<CourseIntroParameter> requestObject);

	/**
	 * 连PC通用课程包体系
	 */
	public ResultObject<List<CourseChapterDto>> selectCourseChapterByCuId(@RequestBody RequestObject<CourseIntroParameter> requestObject);

}