package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PkgGradeBiz;
import com.qht.entity.PkgGrade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pkgGrade")
public class PkgGradeController extends APIBaseController<PkgGradeBiz,PkgGrade> {

}