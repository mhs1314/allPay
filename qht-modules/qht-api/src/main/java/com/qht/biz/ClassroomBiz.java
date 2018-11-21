package com.qht.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qht.entity.Classroom;
import com.qht.mapper.ClassroomMapper;
import com.qht.mapper.StudentMapper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;

/**
 * 在线课堂
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-19 18:25:28
 */
@Service
public class ClassroomBiz extends BaseBiz<ClassroomMapper,Classroom> {
	
	@Autowired
    private ClassroomMapper classroomMapper;
    
	public List<Classroom> getClassroomByPeriodId(String periodId){
		return classroomMapper.getClassroomByPeriodId(periodId);
	}
}