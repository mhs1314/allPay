package com.qht.mapper;

import org.springframework.stereotype.Repository;

import com.qht.entity.Chapter;
import com.qht.model.AppInsertChapterParam;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程章节
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface ChapterMapper extends Mapper<Chapter> {
	/**
	 * 添加章节
	 * @param param
	 * @return
	 */
	Integer appInsertChapter(AppInsertChapterParam param);
}
