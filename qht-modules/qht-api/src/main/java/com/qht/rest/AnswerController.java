package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.AnswerBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.*;
import com.qht.entity.Answer;

import com.qht.model.*;
import com.qht.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnswerController extends APIBaseController<AnswerBiz,Answer> implements AnswerService {
	@Autowired
	private AnswerBiz answerBiz;

	@Override
	@PostMapping("/student/myIndexCourseAnswer")
	@ResponseBody
	public ResultObject<List<MyIndexCourseAnswerDto>> myIndexCourseAnswer(@RequestBody RequestObject<MyIndexCourseAnswerParameter> requestObject) {
		//使用分页插件
		MyIndexCourseAnswerParam param=new MyIndexCourseAnswerParam();
		BeanUtil.copyFields(param, requestObject.getData());
		PageHelper.startPage(Integer.parseInt(requestObject.getData().getPage()),Integer.parseInt(requestObject.getData().getLimit()) );
		requestObject.getData().setTenant_id(getTenantId());
		List<MyIndexCourseAnswerModel> myIndexCourseAnswerDtos=answerBiz.selectMyIndexCourseAnswer(param);
		List<MyIndexCourseAnswerDto> list = BeanUtil.copyList(MyIndexCourseAnswerDto.class, myIndexCourseAnswerDtos);
		PageInfo<MyIndexCourseAnswerDto> count=new PageInfo<>(list);
		ResultObject<List<MyIndexCourseAnswerDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(count.getTotal());
		resultObject.setData(list);
		return resultObject;
	}

	@Override
	@PostMapping("/student/app/indexMyAnswer")
	@ResponseBody
	public ResultObject<List<IndexMyAnswerDto>> indexMyAnswer(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		if(requestObject.getData()==null) {
			ResultObject<List<IndexMyAnswerDto>> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("参数错误");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		List<IndexMyAnswerModel> models=answerBiz.selectIndexMyAnswer(param.getUid(),param.getTenant_id());
		if(models.size()==0) {
			ResultObject<List<IndexMyAnswerDto>> resultObject=new ResultObject<>();
			resultObject.setCode("0");
			resultObject.setMsg("没有数据");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<IndexMyAnswerDto> list = BeanUtil.copyList(IndexMyAnswerDto.class, models);
		ResultObject<List<IndexMyAnswerDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return resultObject;
	}
	@Override
	@PostMapping("/student/app/indexAnswerDetails")
	@ResponseBody
	public ResultObject<IndexAnswerDetailsDto> indexAnswerDetails(@RequestBody RequestObject<UidAndTenantID> requestObject){
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		IndexAnswerDetailsModel model=answerBiz.selectIndexAnswerDetails(param.getUid(),param.getTenant_id());
		IndexAnswerDetailsDto dto=new IndexAnswerDetailsDto();
		if(model==null) {
			ResultObject<IndexAnswerDetailsDto> resultObject=new ResultObject<>();
			resultObject.setCode("0");
			resultObject.setMsg("没有数据");
			resultObject.setData(new IndexAnswerDetailsDto());
			return resultObject;
		}
		BeanUtil.copyFields(dto, model);
		ResultObject<IndexAnswerDetailsDto> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(dto);
		return resultObject;
	}
	@Override
	@PostMapping("/student/app/indexAnswerDetailsAppendAnswer")
	@ResponseBody
	public ResultObject<Void> indexAnswerDetailsAppendAnswer(@RequestBody RequestObject<IndexAnswerDetailsAppendAnswerParameter> requestObject) {
		IndexAnswerDetailsAppendAnswerParam param=new IndexAnswerDetailsAppendAnswerParam();
		if(requestObject.getData()==null) {
			ResultObject<Void> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("没有参数");
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		requestObject.getData().setTanant_id(getTenantId());
		Integer appendAskAnswer=answerBiz.insertAppendAskAnswer(param);
		ResultObject<Void> resultObject=new ResultObject<>();
		if(appendAskAnswer==1){

			resultObject.setCode("0");
			resultObject.setMsg("回答成功");
			return resultObject;
		}

		return resultObject.setMsg("稍后重试");
	}
}