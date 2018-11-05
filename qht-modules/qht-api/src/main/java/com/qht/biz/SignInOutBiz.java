package com.qht.biz;

import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.SignInOut;
import com.qht.mapper.SignInOutMapper;

/**
 * 签到签退
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class SignInOutBiz extends BaseBiz<SignInOutMapper,SignInOut> {
}