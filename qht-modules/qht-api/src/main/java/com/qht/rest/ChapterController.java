package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.ChapterBiz;
import com.qht.entity.Chapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chapter")
public class ChapterController extends APIBaseController<ChapterBiz,Chapter> {

}