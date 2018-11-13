package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.RoleAuthBiz;
import com.qht.entity.RoleAuth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("roleAuth")
public class RoleAuthController extends APIBaseController<RoleAuthBiz,RoleAuth> {

}