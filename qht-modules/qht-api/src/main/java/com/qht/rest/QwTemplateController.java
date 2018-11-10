package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.QwTemplateBiz;
import com.qht.entity.QwTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("qwTemplate")
public class QwTemplateController extends APIBaseController<QwTemplateBiz,QwTemplate> {

}