package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.CoursePkgBiz;
import com.qht.entity.CoursePkg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("coursePkg")
public class CoursePkgController extends APIBaseController<CoursePkgBiz,CoursePkg> {

}