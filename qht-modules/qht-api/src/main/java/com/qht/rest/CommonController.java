package com.qht.rest;

import java.util.ArrayList;
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
import com.qht.biz.OpenRangeBiz;
import com.qht.biz.PkgEditionBiz;
import com.qht.biz.PkgGradeBiz;
import com.qht.biz.PkgLevelBiz;
import com.qht.biz.PkgSubjectBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.AppMyStudentGuardianDto;
import com.qht.dto.CoursePkgListDto;
import com.qht.dto.GradetListDto;
import com.qht.dto.PkgSubjectListDto;
import com.qht.dto.SelectOpenRangeAllDto;
import com.qht.dto.SelectPkgEditionAllDto;
import com.qht.dto.SelectPkgLevelAllDto;
import com.qht.dto.UidAndTenantID;
import com.qht.mapper.PkgEditionMapper;
import com.qht.model.CoursePkgListModel;
import com.qht.model.GradetListModel;
import com.qht.model.PkgSubjectListModel;
import com.qht.model.SelectOpenRangeAllModel;
import com.qht.model.SelectPkgEditionAllModel;
import com.qht.model.SelectPkgLevelAllModel;
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
	@Autowired
	private PkgEditionBiz pkgEditionBiz;
	@Autowired
	private OpenRangeBiz openRangeBiz;
	@Autowired
	private PkgLevelBiz pkgLevelBiz;

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
	/**
	 * 科目
	 */
	@Override
	@PostMapping("/common/subjectList")
	@ResponseBody
	public ResultObject<List<PkgSubjectListDto>> subjectList(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		if(requestObject.getData()==null) {
			ResultObject<List<PkgSubjectListDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		List<PkgSubjectListModel> dto = pkgSubjectBiz.subjectList(param);
		if(dto.size()==0) {
			ResultObject<List<PkgSubjectListDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<PkgSubjectListDto> list = BeanUtil.copyList(PkgSubjectListDto.class, dto);
		ResultObject<List<PkgSubjectListDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}
	/**
	 * 课程包年级
	 */
	@Override
	@PostMapping("/common/gradetList")
	@ResponseBody

	public ResultObject<List<GradetListDto>> gradetList(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<List<GradetListDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		List<GradetListModel> dto = pkgGradeBiz.gradetList(param);
		if(dto.size()==0) {
			ResultObject<List<GradetListDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<GradetListDto> list = BeanUtil.copyList(GradetListDto.class, dto);
		ResultObject<List<GradetListDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}
	/**
	 * 课程包类别
	 */
	@Override
	@PostMapping("/common/courseTypeList")
	@ResponseBody

	public ResultObject<List<CoursePkgListDto>> courseTypeList(
			@RequestBody RequestObject<UidAndTenantID> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<List<CoursePkgListDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());

		List<CoursePkgListModel> dto = coursePkgBiz.courseTypeList(param);
		if(dto.size()==0) {
			ResultObject<List<CoursePkgListDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<CoursePkgListDto> list = BeanUtil.copyList(CoursePkgListDto.class, dto);
		ResultObject<List<CoursePkgListDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}
	/**
	 * 课程包版本
	 */

	@Override
	@PostMapping("/common/pkgEditionList")
	@ResponseBody
	public ResultObject<List<SelectPkgEditionAllDto>> pkgEditionAll(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<List<SelectPkgEditionAllDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());

		List<SelectPkgEditionAllModel> dto = pkgEditionBiz.selectPkgEditionAll(param);
		if(dto.size()==0) {
			ResultObject<List<SelectPkgEditionAllDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<SelectPkgEditionAllDto> list = BeanUtil.copyList(SelectPkgEditionAllDto.class, dto);
		ResultObject<List<SelectPkgEditionAllDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}
	/**
	 * 所有课程范围
	 */
	@Override
	@PostMapping("/common/openRange")
	@ResponseBody
	public ResultObject<List<SelectOpenRangeAllDto>> selectOpenRangeAll(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<List<SelectOpenRangeAllDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());

		List<SelectOpenRangeAllModel> dto = openRangeBiz.selectOpenRangeAll(param);
		if(dto.size()==0) {
			ResultObject<List<SelectOpenRangeAllDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<SelectOpenRangeAllDto> list = BeanUtil.copyList(SelectOpenRangeAllDto.class, dto);
		ResultObject<List<SelectOpenRangeAllDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}
	/**
	 * 所有班级
	 */
	@Override
	@PostMapping("/common/classList")
	@ResponseBody
	public ResultObject<List<SelectPkgLevelAllDto>> selectPkgLevelAll(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		if(requestObject.getData()==null) {
			ResultObject<List<SelectPkgLevelAllDto>> resultObj = new ResultObject<>();
			resultObj.setCode("1");
			resultObj.setMsg("传入参数为空");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		UidAndTenantIDParam param = new UidAndTenantIDParam();

		BeanUtil.copyFields(param, requestObject.getData());

		List<SelectPkgLevelAllModel> dto = pkgLevelBiz.selectPkgLevelAll(param);
		if(dto.size()==0) {
			ResultObject<List<SelectPkgLevelAllDto>> resultObj = new ResultObject<>();
			resultObj.setCode("0");
			resultObj.setMsg("没有数据哦");
			resultObj.setData(new ArrayList<>());
			return resultObj;
		}
		List<SelectPkgLevelAllDto> list = BeanUtil.copyList(SelectPkgLevelAllDto.class, dto);
		ResultObject<List<SelectPkgLevelAllDto>> resultObj = new ResultObject<>();
		resultObj.setCode("0");
		resultObj.setMsg("成功");
		resultObj.setData(list);
		return resultObj;
	}

}
