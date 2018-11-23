package com.qht.mapper;

import org.springframework.stereotype.Repository;

import com.qht.entity.ClassroomMembers;
import tk.mybatis.mapper.common.Mapper;

/**
 * 课堂成员列表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-19 18:25:28
 * @Mapper
 */
@Repository
public interface ClassroomMembersMapper extends Mapper<ClassroomMembers> {
	
}
