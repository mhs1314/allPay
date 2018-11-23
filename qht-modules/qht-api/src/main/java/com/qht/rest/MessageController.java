package com.qht.rest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.MessageBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.MyIndexMessageDto;
import com.qht.dto.MyIndexMessageParamter;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.Message;

import com.qht.model.MyIndexMessageModel;
import com.qht.model.MyIndexMessageParam;
import com.qht.model.UidAndTenantIDParam;
import com.qht.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MessageController extends APIBaseController<MessageBiz,Message> implements MessageService {
	@Autowired
	private MessageBiz messageBiz;

	@Override
	@PostMapping("/student/myIndexMessage")
	@ResponseBody
	public ResultObject<List<MyIndexMessageDto>> myIndexMessage(@RequestBody RequestObject<MyIndexMessageParamter> paramter) {
		MyIndexMessageParam param=new MyIndexMessageParam();
		Integer p=Integer.parseInt(param.getPage());
		Integer l=Integer.parseInt(param.getLimit());
		paramter.getData().setIsread(getTenantId());
		PageHelper.startPage(p,l);
		List<MyIndexMessageModel> list=messageBiz.selectMyIndexMessage(param);
		List<MyIndexMessageDto> lists = BeanUtil.copyList(MyIndexMessageDto.class, list);
		PageInfo<MyIndexMessageDto> count=new PageInfo<>(lists);
		ResultObject<List<MyIndexMessageDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setCount(count.getTotal());
		resultObject.setData(lists);
		return resultObject;

	}
	@Override
	@PostMapping("/student/myIndexDelMessage")
	@ResponseBody
	public ResultObject<Void> deleteMessage(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		ResultObject<Void> resultObject=new ResultObject<>();

		Integer deleteLine=messageBiz.deleteMessages(requestObject.getData().getUid());
		if(deleteLine>0){
			resultObject.setMsg("删除成功");

			resultObject.setCode("0");
			return resultObject;
		}else{
			resultObject.setMsg("删除失败");
			resultObject.setCode("2");
			return resultObject;
		}
	}
	@Override
	@PostMapping("/student/myIndexMessageDetails")
	@ResponseBody
	public ResultObject<MyIndexMessageDto> selectMessageById(@RequestBody RequestObject<UidAndTenantID> requestObject) {
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		MyIndexMessageModel dto=messageBiz.selectMessageById(param);
		MyIndexMessageDto dtod=new MyIndexMessageDto();
		BeanUtil.copyFields(dtod, dto);
		ResultObject<MyIndexMessageDto> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(dtod);
		return resultObject;
	}


}