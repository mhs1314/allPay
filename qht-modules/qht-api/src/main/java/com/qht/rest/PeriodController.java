package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.PeriodBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.*;
import com.qht.entity.Period;

import com.qht.model.*;
import com.qht.services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class PeriodController extends APIBaseController<PeriodBiz,Period> implements PeriodService {
	@Autowired
	private PeriodBiz periodBiz;

	@Override
	@PostMapping("/student/myIndexCourseDetails")
	@ResponseBody
	public ResultObject<MyIndexCourseDetailsDto> myIndexCourseDetails(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<MyIndexCourseDetailsDto> resultObject=new ResultObject<>();
		if(requestObject.getData()==null){
			resultObject.setCode("1");
			resultObject.setData(new MyIndexCourseDetailsDto());
			return resultObject;
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param,requestObject.getData());
		MyIndexCourseDetailsModel data=periodBiz.selectMyIndexCourseDetails(param);
		if(data==null){
			resultObject.setCode("1");
			resultObject.setData(new MyIndexCourseDetailsDto());
			return resultObject;
		}
		MyIndexCourseDetailsDto dto = new MyIndexCourseDetailsDto();
		BeanUtil.copyFields(dto,data);
		resultObject.setCode("0");
		resultObject.setData(dto);
		resultObject.setMsg("成功");
		return resultObject;
	}

	@Override
	@PostMapping("/student/myIndexBuyrecordCourseBack")
	@ResponseBody
	public ResultObject<List<MyIndexBuyRecordCourseBackDto>> myIndexBuyRecordCourseBack(@RequestBody RequestObject<MyIndexBuyRecordCourseBackParameter> requestObject) {
		requestObject.getData().setTenant_id(getTenantId());
		MyIndexBuyRecordCourseBackParam param=new MyIndexBuyRecordCourseBackParam();
		BeanUtil.copyFields(param, requestObject.getData());
		PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()));
		List<MyIndexBuyRecordCourseBackModel> myIndexBuyRecordCourseBackDtos=periodBiz.selectMyIndexBuyRecordCourseBack(param);
		List<MyIndexBuyRecordCourseBackDto> list = BeanUtil.copyList(MyIndexBuyRecordCourseBackDto.class, myIndexBuyRecordCourseBackDtos);
		PageInfo<MyIndexBuyRecordCourseBackDto> count=new PageInfo<>(list);
		ResultObject<List<MyIndexBuyRecordCourseBackDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(count.getTotal());
		resultObject.setData(list);
		return resultObject;
	}

	@Override
	@PostMapping("/student/indexCourseDetails")
	@ResponseBody
	public ResultObject<List<IndexCourseDetailsDto>> indexCourseDetails(@RequestBody RequestObject<UidAndTenantID> req) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, req.getData());
		List<IndexCourseDetailsModel> indexCourseDetailsDtos=periodBiz.selectIndexCourseDetails(param.getUid(),param.getTenant_id());
		List<IndexCourseDetailsDto> list = BeanUtil.copyList(IndexCourseDetailsDto.class, indexCourseDetailsDtos);
		ResultObject<List<IndexCourseDetailsDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return resultObject;
	}
}