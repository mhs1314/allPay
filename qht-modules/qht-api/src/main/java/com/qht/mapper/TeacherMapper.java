package com.qht.mapper;

import org.apache.ibatis.annotations.Param;

import com.qht.dto.TeacherDto;
import com.qht.entity.Teacher;

import tk.mybatis.mapper.common.Mapper;

/**
 * 教师
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */

public interface TeacherMapper extends Mapper<Teacher> {
	/**
     * 学生登陆
     * @param account
     * @param password
     * @return
     */
	TeacherDto teacherLogin(@Param("account") String account, @Param("password") String password);
}
