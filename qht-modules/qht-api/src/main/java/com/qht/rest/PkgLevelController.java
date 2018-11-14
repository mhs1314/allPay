package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PkgLevelBiz;
import com.qht.entity.PkgLevel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pkgLevel")
public class PkgLevelController extends APIBaseController<PkgLevelBiz,PkgLevel> {

}