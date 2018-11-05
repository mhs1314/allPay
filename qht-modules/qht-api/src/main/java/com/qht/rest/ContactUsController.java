package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.ContactUsBiz;
import com.qht.entity.ContactUs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("contactUs")
public class ContactUsController extends BaseController<ContactUsBiz,ContactUs> {

}