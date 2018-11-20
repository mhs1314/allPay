package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.SchoolBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.TenantSchoolDto;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.School;

import com.qht.model.TenantSchoolModel;
import com.qht.model.UidAndTenantIDParam;
import com.qht.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class SchoolController extends APIBaseController<SchoolBiz,School> implements SchoolService {
	@Autowired
	private SchoolBiz schoolBiz;

	@Override
	@PostMapping("/student/tenantSchool")
	@ResponseBody
	public ResultObject<TenantSchoolDto> tenantSchool(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		TenantSchoolModel tenantSchoolDto=schoolBiz.selectTenantSchool(param);
		TenantSchoolDto dto=new TenantSchoolDto();
		BeanUtil.copyFields(dto, tenantSchoolDto);
		ResultObject<TenantSchoolDto> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(dto);
		return resultObject;
	}

}