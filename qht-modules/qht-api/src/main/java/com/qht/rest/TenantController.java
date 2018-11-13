package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.TenantBiz;
import com.qht.entity.Tenant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tenant")
public class TenantController extends APIBaseController<TenantBiz,Tenant> {

}