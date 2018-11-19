package com.qht.biz;

import org.springframework.stereotype.Service;

import com.qht.entity.ClassroomMembers;
import com.qht.mapper.ClassroomMembersMapper;
import com.github.wxiaoqi.security.common.biz.BaseBiz;

/**
 * 课堂成员列表
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-19 18:25:28
 */
@Service
public class ClassroomMembersBiz extends BaseBiz<ClassroomMembersMapper,ClassroomMembers> {
}