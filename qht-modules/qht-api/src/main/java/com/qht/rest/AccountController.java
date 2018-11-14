package com.qht.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qht.biz.AccountBiz;
import com.qht.entity.Account;

@Controller
@RequestMapping("account")
public class AccountController extends APIBaseController<AccountBiz,Account>{

}