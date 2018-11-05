package com.qht.biz;

import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.PaymentMethod;
import com.qht.mapper.PaymentMethodMapper;

/**
 * 支付方式
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class PaymentMethodBiz extends BaseBiz<PaymentMethodMapper,PaymentMethod> {
}