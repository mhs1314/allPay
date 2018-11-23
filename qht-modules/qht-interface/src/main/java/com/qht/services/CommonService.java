package com.qht.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.AppInsertChapterParameter;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.GradetListDto;
import com.qht.dto.InsertCoursePkgParameter;
import com.qht.dto.LoginInfoDto;
import com.qht.dto.PkgSubjectListDto;
import com.qht.dto.SelectOpenRangeAllDto;
import com.qht.dto.SelectPkgDto;
import com.qht.dto.SelectPkgEditionAllDto;
import com.qht.dto.SelectPkgLevelAllDto;
import com.qht.dto.StudentDto;
import com.qht.dto.UidAndTenantID;

/**
 * 公共
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface CommonService {
	/**
	 * 所有科目
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<PkgSubjectListDto>> subjectList(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 所有年级
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<GradetListDto>> gradetList(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 所有课程类别
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<CoursePkgListDto>> courseTypeList(@RequestBody RequestObject<UidAndTenantID> requestObject);
	/**
	 * 所有课程版本
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<SelectPkgEditionAllDto>> pkgEditionAll(@RequestBody RequestObject<UidAndTenantID> requestObject);
	/**
	 * 所有课程包范围
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<SelectOpenRangeAllDto>> selectOpenRangeAll(@RequestBody RequestObject<UidAndTenantID> requestObject);
	/**
	 * 所有班级
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<SelectPkgLevelAllDto>> selectPkgLevelAll(@RequestBody RequestObject<UidAndTenantID> requestObject);
	
	
}
