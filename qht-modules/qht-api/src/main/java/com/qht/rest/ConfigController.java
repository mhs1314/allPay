package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.ConfigBiz;
import com.qht.entity.Config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("config")
public class ConfigController extends BaseController<ConfigBiz,Config> {

}