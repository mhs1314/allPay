package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PkgSubjectBiz;
import com.qht.entity.PkgSubject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pkgSubject")
public class PkgSubjectController extends APIBaseController<PkgSubjectBiz,PkgSubject> {

}