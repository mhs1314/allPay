package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.OpenRangeBiz;
import com.qht.entity.OpenRange;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("openRange")
public class OpenRangeController extends BaseController<OpenRangeBiz,OpenRange> {

}