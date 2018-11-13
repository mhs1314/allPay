package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.biz.PaymentMethodBiz;
import com.qht.entity.PaymentMethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("paymentMethod")
public class PaymentMethodController extends APIBaseController<PaymentMethodBiz,PaymentMethod> {

}