package com.qht.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.qht.RequestObject;
import com.qht.ResultBuilder;
import com.qht.ResultObject;
import com.qht.biz.TencentCloud;
import com.qht.dto.MessageParameter;
import com.qht.dto.MsgBodyDto;

@Controller
@RequestMapping("webrtc")
public class MessagePushController {
	
	private static final Logger log = LoggerFactory.getLogger(MessagePushController.class);
	
	@Autowired
	private TencentCloud cloud;
	/**
	 * 消息推送
	 */
	@PostMapping("msgPush")
	@ResponseBody
	public ResultObject<MsgBodyDto> msgPush(@RequestBody RequestObject<MessageParameter> requestObject) {
		MessageParameter param = requestObject.getData();
		if(param == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		String json = cloud.imPush(param.getGroup_id(), param.getContent(), param.getMember());
		MsgBodyDto body = JSON.parseObject(json, MsgBodyDto.class);
		return ResultBuilder.success(requestObject, body);
	}
}
