package com.qht.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.TeacherDto;
import com.qht.entity.Teacher;
import com.qht.mapper.StudentMapper;
import com.qht.mapper.TeacherMapper;

/**
 * 教师
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class TeacherBiz extends BaseBiz<TeacherMapper,Teacher> {
	@Autowired
    private TeacherMapper teacherMapper;

    /**
     * 教师登录
     * @param account
     * @param password
     * @return
     */
    public TeacherDto teacherLogin(String account, String password){    	
        return teacherMapper.teacherLogin(account,password);
    }
}