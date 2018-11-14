package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.ExtractRecordBiz;
import com.qht.entity.ExtractRecord;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("extractRecord")
public class ExtractRecordController extends APIBaseController<ExtractRecordBiz,ExtractRecord> {

}