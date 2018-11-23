package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Chapter;
import com.qht.mapper.ChapterMapper;
import com.qht.model.AppInsertChapterParam;
import com.qht.model.CourseChapterModel;
import com.qht.model.UidAndTenantIDParam;

/**
 * 课程章节
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class ChapterBiz extends BaseBiz<ChapterMapper,Chapter> {
	@Autowired
	private ChapterMapper chapterMapper;
	
	/**
	 * 添加章节
	 * @param param
	 * @return
	 */
	public Integer appInsertChapter(AppInsertChapterParam param) {
		return chapterMapper.appInsertChapter(param);
	}
	/**
	 * 课程包id查章节
	 */
	public List<CourseChapterModel> selectChapterByid(UidAndTenantIDParam param){
		return chapterMapper.selectChapterByid(param);
	}
}