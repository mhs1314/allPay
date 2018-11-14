package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.SchoolBiz;
import com.qht.entity.School;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("school")
public class SchoolController extends APIBaseController<SchoolBiz,School> {

}