package com.qht.biz;

import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.UserRole;
import com.qht.mapper.UserRoleMapper;

/**
 * 用户角色
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class UserRoleBiz extends BaseBiz<UserRoleMapper,UserRole> {
}