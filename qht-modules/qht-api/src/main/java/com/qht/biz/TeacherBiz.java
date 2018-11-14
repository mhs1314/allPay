package com.qht.biz;

import com.qht.dto.AppTeacherCourseDto;
import com.qht.dto.AppTeacherEvaluationDto;
import com.qht.dto.TeacherDetailsDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.TeacherDto;
import com.qht.entity.Teacher;
import com.qht.mapper.StudentMapper;
import com.qht.mapper.TeacherMapper;

import java.util.List;

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
    /**
     * 名师详情-基本信息
     * @param uid
     * @param tid
     * @return
     */
   public TeacherDetailsDto teacherDetails(String uid,String tid){
       return teacherMapper.teacherDetails(uid,tid);
   }
    /**
     * 名师详情-所有课程
     * @param uid
     * @param tid
     * @return
     */
   public List<AppTeacherCourseDto>  appTeacherCourseDto  (String uid,String tid){
        return teacherMapper.appTeacherCourseDto(uid,tid);
    }

    /**
     * 名师详情-所有评论
     * @param uid
     * @param tid
     * @param eval
     * @return
     */
   public  List<AppTeacherEvaluationDto> teacherEvaluation(String uid,String tid,Integer eval){
       return teacherMapper.teacherEvaluation(uid,tid,eval);
   }

}