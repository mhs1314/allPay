package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.LoginLogBiz;
import com.qht.entity.LoginLog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loginLog")
public class LoginLogController extends APIBaseController<LoginLogBiz,LoginLog> {

}