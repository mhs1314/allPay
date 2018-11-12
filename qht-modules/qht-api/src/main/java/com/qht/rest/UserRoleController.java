package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.UserRoleBiz;
import com.qht.entity.UserRole;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userRole")
public class UserRoleController extends APIBaseController<UserRoleBiz,UserRole> {

}