package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.ChapterBiz;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.CourseIntroParameter;
import com.qht.entity.Chapter;

import com.qht.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChapterController extends APIBaseController<ChapterBiz,Chapter> implements ChapterService {
	@Autowired
	private ChapterBiz chapterBiz;

	@Override
	@PostMapping("/student/courseChapter")
	@ResponseBody
	public ResultObject<List<CourseChapterDto>> courseChapter(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
		ResultObject<List<CourseChapterDto>> resultObject=new ResultObject<>();
		if(requestObject.getData()==null){
			return resultObject.setMsg("参数为空");
		}
		List<CourseChapterDto> list=chapterBiz.selectCourseChapter(requestObject.getData().getUid(),requestObject.getData().getTenant_id());
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return resultObject;
	}
	/**
	 * 课程体系
	 */
	@Override
	@PostMapping("/student/app/courseChapter")
	@ResponseBody
	public ResultObject<List<CourseChapterDto>> selectCourseChapterByCuId(@RequestBody RequestObject<CourseIntroParameter> requestObject) {
		return this.courseChapter(requestObject);
	}

}