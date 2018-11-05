package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PkgTypeBiz;
import com.qht.entity.PkgType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pkgType")
public class PkgTypeController extends BaseController<PkgTypeBiz,PkgType> {

}