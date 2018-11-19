package com.qht.mapper;

import com.qht.model.*;
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

	TeacherDetailsModel teacherDetails(@Param("uid")String uid,@Param("tid")String tid);
    /**
     * 名师详情-所有课程
     * @param uid
     * @param tid
     * @return
     */

    List<AppTeacherCourseModel> appTeacherCourseDto  (@Param("uid")String uid, @Param("tid")String tid);

    /**
     * 名师详情-所有评论
     * @param uid
     * @param tid
     * @param eval
     * @return
     */

    List<AppTeacherEvaluationModel> teacherEvaluation(@Param("uid")String uid, @Param("tid")String tid,@Param("eval")Integer eval);

	/**
	 * 教师|端首页--我的课程
	 * @param data
	 * @return
	 */

    List<IndexMyCourseModel> selectIndexMyCourseDto(IndexMyCourseParam data);

	/**
	 * 教师端首页--我的课程包
	 * @param data
	 * @return
	 */
	List<IndexMyCourseListModel> selectIndexMyCourseList(IndexMyCourseListParam data);

	/**
	 * 教师端首页--课程答疑列表
	 * @param param
	 * @return
	 */
	List<IndexCourseAnswerModel> selectIndexCourseAnswer(IndexCourseAnswerParam param);
	/**
	 * 教师端首页--我的消息
	 * @param param
	 * @return
	 */
	List<IndexMessageModel> selectIndexMessage(IndexMessageParam param);
	/**
	 * app个人中心教室信息
	 */
	AppSelectTeacherByidModel selectTeacherByid(UidAndTenantIDParam param);

	/**
	 * 查询老师信息
	 * @param param
	 * @return
	 */
    PCTeacherInfoModel selectTeacherInfo(UidAndTenantIDParam param);

	/**
	 * 修改信息
	 * @param param
	 * @return
	 */
//	Integer updateTeahcerInfo(EditTeacherInfoParam param);
}
