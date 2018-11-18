package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.dto.AppStudentParameter;
import com.qht.dto.PkgSubjectListDto;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.PkgSubject;
import com.qht.model.PkgSubjectListModel;
import com.qht.model.UidAndTenantIDParam;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程包科目
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface PkgSubjectMapper extends Mapper<PkgSubject> {
	/**
	 * 查看所有科目
	 * @param parameter
	 * @return
	 */
	List<PkgSubjectListModel> subjectList(UidAndTenantIDParam ut);
	
}
