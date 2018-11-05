package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.SignInOutBiz;
import com.qht.entity.SignInOut;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("signInOut")
public class SignInOutController extends BaseController<SignInOutBiz,SignInOut> {

}