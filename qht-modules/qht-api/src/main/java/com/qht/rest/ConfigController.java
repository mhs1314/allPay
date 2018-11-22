package com.qht.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qht.RequestObject;
import com.qht.ResultBuilder;
import com.qht.ResultObject;
import com.qht.biz.ConfigBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.ConfigDto;
import com.qht.entity.Config;

@Controller
@RequestMapping("config")
public class ConfigController extends APIBaseController<ConfigBiz, Config> {	
	
	@Autowired
	private ConfigBiz biz;
	/**
     * 获取应用配置信息
     * @return
     */
	@PostMapping("getAppConfig")
	@ResponseBody
	public ResultObject<ConfigDto> getAppConfig(@RequestBody RequestObject<Void> requestObject){
		Config cfg = biz.getConfig("PZ001");
		ConfigDto dto = new ConfigDto();
		BeanUtil.copyFields(dto, cfg);
		return ResultBuilder.success(requestObject.getRequestId(),dto);
	}
	
}