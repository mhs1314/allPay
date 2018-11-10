package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.AccountBiz;
import com.qht.entity.Account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("account")
public class AccountController extends BaseController<AccountBiz,Account>{

}