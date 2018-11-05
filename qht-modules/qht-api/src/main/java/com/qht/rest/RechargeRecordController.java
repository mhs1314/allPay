package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.RechargeRecordBiz;
import com.qht.entity.RechargeRecord;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rechargeRecord")
public class RechargeRecordController extends BaseController<RechargeRecordBiz,RechargeRecord> {

}