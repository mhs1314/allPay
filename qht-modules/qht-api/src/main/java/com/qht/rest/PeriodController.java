package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PeriodBiz;
import com.qht.entity.Period;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("period")
public class PeriodController extends BaseController<PeriodBiz,Period> {

}