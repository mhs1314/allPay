package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.AnswerBiz;
import com.qht.common.util.BeanUtil;
import com.qht.common.util.IdGenUtil;
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
import java.util.Date;
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
		 for (IndexMyAnswerModel mode :models){
		 	if(mode.getType()==null){
		 		mode.setType(1);
			}
		 }
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
		if(model!=null){
			if(model.getType()==null){
				model.setType(1);
			}
		}

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
	/**
	 * app老师答疑列表
	 */
	@Override
	@PostMapping("/teacher/app/myCourseAnswer")
	@ResponseBody
	public ResultObject<List<AppSelectAnwerListDto>> appSelectAnwerList(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		if(requestObject.getData()==null) {
			ResultObject<List<AppSelectAnwerListDto>> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("参数错误");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		List<AppSelectAnwerListModel> models=answerBiz.appSelectAnwerList(param);
		for (AppSelectAnwerListModel model:models){
			if(model.getType()==null){
				model.setType("1");
			}
		}
		if(models.size()==0) {
			ResultObject<List<AppSelectAnwerListDto>> resultObject=new ResultObject<>();
			resultObject.setCode("0");
			resultObject.setMsg("没有数据");
			resultObject.setData(new ArrayList<>());
			return resultObject;
		}
		List<AppSelectAnwerListDto> list = BeanUtil.copyList(AppSelectAnwerListDto.class, models);
		ResultObject<List<AppSelectAnwerListDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(Long.parseLong(list.size()+""));
		resultObject.setData(list);
		return resultObject;
	}
	/**
	 * 学生答疑追问
	 */

	@Override
	@PostMapping("/student/app/askClassAgain")
	@ResponseBody
	public ResultObject<Void> appUpdateStudentAnswer(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		if(requestObject.getData()==null) {
			ResultObject<Void> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("没有参数");
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		Integer appendAskAnswer=answerBiz.appUpdateStudentAnswer(param);
		ResultObject<Void> resultObject=new ResultObject<>();
		if(appendAskAnswer==null||appendAskAnswer<=0) {

			resultObject.setCode("1");
			resultObject.setMsg("追问失败");
			return resultObject;
		}

		resultObject.setCode("0");
		resultObject.setMsg("追问成功");
		return resultObject;
	}
	/**
	 * 老师追答
	 */
	@Override
	@PostMapping("teacher/app/myCourseAnswerHfAgain")
	@ResponseBody
	public ResultObject<Void> appUpdateTeacherAnswer(RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		if(requestObject.getData()==null) {
			ResultObject<Void> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("没有参数");
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		Integer appendAskAnswer=answerBiz.appUpdateTeacherAnswer(param);
		ResultObject<Void> resultObject=new ResultObject<>();
		if(appendAskAnswer==null||appendAskAnswer<=0) {

			resultObject.setCode("1");
			resultObject.setMsg("回答失败");
			return resultObject;
		}

		resultObject.setCode("0");
		resultObject.setMsg("回答成功");
		return resultObject;
	}
	/**
	 * app老师第一次答疑回复
	 */
	@Override
	@PostMapping("teacher/app/myCourseAnswerHf")
	@ResponseBody
	public ResultObject<Void> appInsertTeacherAnser(@RequestBody RequestObject<AppInsertTeacherAnswerParameter> requestObject) {
		AppInsertTeacherAnswerParam param=new AppInsertTeacherAnswerParam();
		if(requestObject.getData()==null) {
			ResultObject<Void> resultObject=new ResultObject<>();
			resultObject.setCode("1");
			resultObject.setMsg("没有参数");
			return resultObject;
		}
		BeanUtil.copyFields(param, requestObject.getData());
		param.setUid(IdGenUtil.getUid("DY"));
		param.setType("2");
		param.setTime(new Date());
		param.setAnswer_time(new Date());
		Integer appendAskAnswer=answerBiz.appInsertTeacherAnser(param);
		ResultObject<Void> resultObject=new ResultObject<>();
		if(appendAskAnswer==null||appendAskAnswer<=0) {

			resultObject.setCode("1");
			resultObject.setMsg("回答失败");
			return resultObject;
		}

		resultObject.setCode("0");
		resultObject.setMsg("回答成功");
		return resultObject;
	}
}