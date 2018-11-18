package com.qht.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Chapter;
import com.qht.mapper.ChapterMapper;
import com.qht.model.AppInsertChapterParam;

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
}