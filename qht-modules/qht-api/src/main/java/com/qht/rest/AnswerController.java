package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.AnswerBiz;
import com.qht.entity.Answer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("answer")
public class AnswerController extends APIBaseController<AnswerBiz,Answer> {

}