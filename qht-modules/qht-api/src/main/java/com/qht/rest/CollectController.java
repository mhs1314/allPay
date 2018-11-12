package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.CollectBiz;
import com.qht.entity.Collect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("collect")
public class CollectController extends APIBaseController<CollectBiz,Collect> {

}