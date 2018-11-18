package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.dto.AppStudentParameter;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.CoursePkg;
import com.qht.model.CoursePkgListModel;
import com.qht.model.InsertCoursePkgParam;
import com.qht.model.UidAndTenantIDParam;

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
	List<CoursePkgListModel>courseTypeList(UidAndTenantIDParam ut);
	/**
	 * 添加课程包
	 * @param param
	 * @return
	 */
	Integer indexAddLCourse(InsertCoursePkgParam param);
	/**
	 * 修改课程包信息
	 */
	Integer appUpdateCoursePkgByid(InsertCoursePkgParam param);
	
}
