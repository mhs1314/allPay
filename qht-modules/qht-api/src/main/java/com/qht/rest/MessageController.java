package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.MessageBiz;
import com.qht.entity.Message;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("message")
public class MessageController extends BaseController<MessageBiz,Message> {

}