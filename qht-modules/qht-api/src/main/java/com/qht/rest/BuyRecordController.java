package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.BuyRecordBiz;
import com.qht.entity.BuyRecord;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("buyRecord")
public class BuyRecordController extends APIBaseController<BuyRecordBiz,BuyRecord> {

}