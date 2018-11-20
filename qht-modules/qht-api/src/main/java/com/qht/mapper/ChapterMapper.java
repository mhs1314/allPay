package com.qht.mapper;

import java.util.List;

import com.qht.dto.CourseChapterDto;
import feign.Param;
import org.springframework.stereotype.Repository;

import com.qht.entity.Chapter;
import com.qht.model.AppInsertChapterParam;
import com.qht.model.CourseChapterModel;
import com.qht.model.UidAndTenantIDParam;

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
	/**
	 * 课程包id查章节
	 */
	List<CourseChapterModel> selectChapterByid(UidAndTenantIDParam param);

	/**
	 * 课程详情--课程包体系
	 * @param uid
	 * @param tenant_id
	 * @return
	 */
	List<CourseChapterDto> selectCourseChapter(@Param("uid")String uid, @Param("tenant_id")String tenant_id);
}
