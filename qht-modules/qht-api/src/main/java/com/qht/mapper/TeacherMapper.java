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
	 * 教师端首页--添加录播课程包
	 * @param data
	 * @return
	 */
	Integer insertIndexAddLcourse(IndexAddLcourseParam data);

    Integer insertChapter(IndexAddLcourseParam data);

    Integer insertPeriod(IndexAddLcourseParam data);
    /**
     * 教师端首页--添加直播课程包
     * @param param
     * @return
     */
	Integer insertIndexAddZcourse(IndexAddZcourseParam param);

	Integer insertChapterZ(IndexAddZcourseParam param);

	Integer insertPeriodZ(IndexAddZcourseParam param);
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
}
