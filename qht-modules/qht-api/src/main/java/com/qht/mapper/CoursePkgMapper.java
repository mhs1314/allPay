package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.dto.AppStudentParameter;
import com.qht.dto.CoursePkgListDto;
import com.qht.entity.CoursePkg;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程包
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface CoursePkgMapper extends Mapper<CoursePkg> {
	/**
	 * 查询所有课程包
	 * @return
	 */
	List<CoursePkgListDto>courseTypeList();
	
}
