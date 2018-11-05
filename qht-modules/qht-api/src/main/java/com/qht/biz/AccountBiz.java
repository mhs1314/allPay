package com.qht.biz;

import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Account;
import com.qht.mapper.AccountMapper;

/**
 * 提现账户
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class AccountBiz extends BaseBiz<AccountMapper,Account> {
}