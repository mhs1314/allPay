package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.BuyRecordBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.*;
import com.qht.entity.BuyRecord;

import com.qht.model.*;
import com.qht.services.BuyRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class BuyRecordController extends APIBaseController<BuyRecordBiz,BuyRecord> implements BuyRecordService {
	@Autowired
	private BuyRecordBiz buyRecordBiz;
	@Override
	@PostMapping("/student/myIndexCourse")
	@ResponseBody
	public ResultObject<List<MyIndexCourseDto>> myIndexCourse(@RequestBody RequestObject<MyIndexCourseParameter> requestObject) {
		//使用分页插件
		MyIndexCourseParam param=new MyIndexCourseParam();
		PageHelper.startPage(Integer.parseInt(param.getPage()), Integer.parseInt(param.getLimit()));
		requestObject.getData().setTenant_id(getTenantId());
		List<MyIndexCourseModel> myIndexCourseDtos=buyRecordBiz.selectMyIndexCourse(param);
		List<MyIndexCourseDto> list = BeanUtil.copyList(MyIndexCourseDto.class, myIndexCourseDtos);
		PageInfo<MyIndexCourseDto> count=new PageInfo<>(list);
		ResultObject<List<MyIndexCourseDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(count.getTotal());
		resultObject.setData(list);
		return resultObject;
	}

	@Override
	@PostMapping("/student/myIndexBuyrecord")
	@ResponseBody
	public ResultObject<List<MyIndexBuyRecordDto>> myIndexBuyRecord(@RequestBody RequestObject<MyIndexBuyRecordParameter> requestObject) {
		//使用分页插件
		MyIndexBuyRecordParam param=new MyIndexBuyRecordParam();
		BeanUtil.copyFields(param, requestObject.getData());
		PageHelper.startPage(Integer.parseInt(param.getPage()),Integer.parseInt(param.getLimit()) );
		requestObject.getData().setTenant_id(getTenantId());
		List<MyIndexBuyRecordModel> myIndexBuyRecordDtos=buyRecordBiz.selectMyIndexBuyRecourd(param);
		List<MyIndexBuyRecordDto> list = BeanUtil.copyList(MyIndexBuyRecordDto.class, myIndexBuyRecordDtos);
		PageInfo<MyIndexBuyRecordDto> count=new PageInfo<>(list);
		ResultObject<List<MyIndexBuyRecordDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(count.getTotal());
		resultObject.setData(list);
		return resultObject;
	}

	//消費記錄
	@Override
	@PostMapping("/student/myIndexMyintegralDetail")
	@ResponseBody
	public ResultObject<List<MyIndexMyintegralDetailDto>> myIndexMyintegralDetail(@RequestBody RequestObject<MyIndexMyintegralDetailParameter> parameter) {
		MyIndexMyintegralDetailParam param=new MyIndexMyintegralDetailParam();
		BeanUtil.copyFields(param, parameter.getData());
		parameter.getData().setTenant_id(getTenantId());
		Integer p=Integer.parseInt(param.getPage());
		Integer l=Integer.parseInt(param.getLimit());
		PageHelper.startPage(p,l);
		List<MyIndexMyintegralDetailModel> list=buyRecordBiz.myIndexMyintegralDetail(param);
		List<MyIndexMyintegralDetailDto> lists = BeanUtil.copyList(MyIndexMyintegralDetailDto.class, list);
		PageInfo<MyIndexMyintegralDetailDto> count=new PageInfo<>(lists);
		ResultObject<List<MyIndexMyintegralDetailDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(count.getTotal());
		resultObject.setData(lists);
		return resultObject;
	}
}