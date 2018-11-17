package com.qht.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.auth.util.RequestContextUtil;
import com.qht.biz.CoursePkgBiz;
import com.qht.biz.PkgGradeBiz;
import com.qht.biz.PkgSubjectBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.AppMyStudentGuardianDto;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.GradetListDto;
import com.qht.dto.PkgSubjectListDto;
import com.qht.dto.UidAndTenantID;
import com.qht.model.CoursePkgListModel;
import com.qht.model.GradetListModel;
import com.qht.model.PkgSubjectListModel;
import com.qht.model.UidAndTenantIDParam;
import com.qht.services.CommonService;

@Controller
@RequestMapping("/common")
public class CommonController implements CommonService {
	@Autowired
	private PkgSubjectBiz pkgSubjectBiz;
	@Autowired
	private PkgGradeBiz pkgGradeBiz;
	@Autowired
	private CoursePkgBiz coursePkgBiz;

	/**
	 * 
	 * 得到tenant_id
	 * 
	 * @return
	 *
	 */
	public String getTenantId() {
		/*
		 * String tenant_id=null; TeacherDto
		 * studentDto=(TeacherDto)request.getSession().getAttribute("user_session_key");
		 * if (studentDto!=null){ tenant_id=studentDto.getTenant_id(); } return
		 * tenant_id == null ? "11": tenant_id;
		 */
		return RequestContextUtil.getTenantId();
	}

	@Override
	@PostMapping("/common/subjectList")
	@ResponseBody
	public ResultObject<List<PkgSubjectListDto>> subjectList(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());
		List<PkgSubjectListModel> dto = pkgSubjectBiz.subjectList(param);
		List<PkgSubjectListDto> list = BeanUtil.copyList(PkgSubjectListDto.class, dto);
		ResultObject<List<PkgSubjectListDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}

	@Override
	@PostMapping("/common/gradetList")
	@ResponseBody

	public ResultObject<List<GradetListDto>> gradetList(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<GradetListModel> dto = pkgGradeBiz.gradetList(param);
		List<GradetListDto> list = BeanUtil.copyList(GradetListDto.class, dto);
		ResultObject<List<GradetListDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}

	@Override
	@PostMapping("/common/courseTypeList")
	@ResponseBody

	public ResultObject<List<CoursePkgListDto>> courseTypeList(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());

		List<CoursePkgListModel> dto = coursePkgBiz.courseTypeList(param);
		List<CoursePkgListDto> list = BeanUtil.copyList(CoursePkgListDto.class, dto);
		ResultObject<List<CoursePkgListDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}

}
