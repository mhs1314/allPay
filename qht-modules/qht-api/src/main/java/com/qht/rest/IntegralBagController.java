package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.IntegralBagBiz;
import com.qht.entity.IntegralBag;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("integralBag")
public class IntegralBagController extends BaseController<IntegralBagBiz,IntegralBag> {

}