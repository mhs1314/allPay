package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.InterestLabelBiz;
import com.qht.entity.InterestLabel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("interestLabel")
public class InterestLabelController extends APIBaseController<InterestLabelBiz,InterestLabel> {

}