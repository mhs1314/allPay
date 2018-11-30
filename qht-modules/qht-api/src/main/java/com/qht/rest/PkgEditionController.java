package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PkgEditionBiz;
import com.qht.entity.PkgEdition;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pkgEdition")
public class PkgEditionController extends APIBaseController<PkgEditionBiz,PkgEdition> {

}