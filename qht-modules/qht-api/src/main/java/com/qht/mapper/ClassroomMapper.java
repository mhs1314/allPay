package com.qht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qht.entity.Classroom;

import tk.mybatis.mapper.common.Mapper;

/**
 * 在线课堂
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-19 18:25:28
 * @Mapper
 */
@Repository
public interface ClassroomMapper extends Mapper<Classroom> {
	
	public List<Classroom> getClassroomByPeriodId(@Param("periodId") String periodId);
}
