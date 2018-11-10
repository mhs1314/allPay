package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.GuardianBiz;
import com.qht.entity.Guardian;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("guardian")
public class GuardianController extends APIBaseController<GuardianBiz,Guardian> {

}