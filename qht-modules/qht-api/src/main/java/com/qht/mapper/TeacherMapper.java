package com.qht.mapper;

import com.qht.dto.AppTeacherCourseDto;
import com.qht.dto.AppTeacherEvaluationDto;
import com.qht.dto.TeacherDetailsDto;
import org.apache.ibatis.annotations.Param;

import com.qht.dto.TeacherDto;
import com.qht.entity.Teacher;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 教师
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface TeacherMapper extends Mapper<Teacher> {
	/**
     * 学生登陆
     * @param account
     * @param password
     * @return
     */
	TeacherDto teacherLogin(@Param("account") String account, @Param("password") String password);

	/**
	 * 名师详情-基本信息
	 * @param uid
	 * @param tid
	 * @return
	 */
	TeacherDetailsDto teacherDetails(@Param("uid")String uid,@Param("tid")String tid);
    /**
     * 名师详情-所有课程
     * @param uid
     * @param tid
     * @return
     */
    List<AppTeacherCourseDto> appTeacherCourseDto  (@Param("uid")String uid, @Param("tid")String tid);

    /**
     * 名师详情-所有评论
     * @param uid
     * @param tid
     * @param eval
     * @return
     */
    List<AppTeacherEvaluationDto> teacherEvaluation(@Param("uid")String uid, @Param("tid")String tid,@Param("eval")Integer eval);
}
