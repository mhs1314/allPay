package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.AttachBiz;
import com.qht.entity.Attach;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("attach")
public class AttachController extends APIBaseController<AttachBiz,Attach> {

}