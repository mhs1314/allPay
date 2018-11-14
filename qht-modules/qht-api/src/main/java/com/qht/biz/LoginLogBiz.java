package com.qht.biz;

import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.LoginLog;
import com.qht.mapper.LoginLogMapper;

/**
 * 登录日志
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class LoginLogBiz extends BaseBiz<LoginLogMapper,LoginLog> {
}