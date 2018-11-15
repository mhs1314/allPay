package com.qht.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.GradetListDto;
import com.qht.dto.LoginInfoDto;
import com.qht.dto.PkgSubjectListDto;
import com.qht.dto.StudentDto;

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
	public ResultObject<List<PkgSubjectListDto>> subjectList(@RequestBody RequestObject<Void> requestObject);

	/**
	 * 所有年级
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<GradetListDto>> gradetList(@RequestBody RequestObject<Void> requestObject);

	/**
	 * 所有课程包
	 * 
	 * @param requestObject
	 * @return
	 */
	public ResultObject<List<CoursePkgListDto>> courseTypeList(@RequestBody RequestObject<Void> requestObject);

}
