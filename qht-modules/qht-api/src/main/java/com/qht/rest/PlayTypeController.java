package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PlayTypeBiz;
import com.qht.entity.PlayType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("playType")
public class PlayTypeController extends APIBaseController<PlayTypeBiz,PlayType> {

}