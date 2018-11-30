package com.qht.mapper;

import com.qht.entity.Tag;

import com.qht.model.AppStudentParam;
import com.qht.model.TagModel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 标签表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface TagMapper extends Mapper<Tag> {

	/**
	 * 查看兴趣标签
	 * @param parameter
	 * @return
	 */
	List<TagModel> appMyStudentInterest (AppStudentParam parameter);


}
