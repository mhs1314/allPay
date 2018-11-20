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
	 * app个人中心教室信息
	 */
	AppSelectTeacherByidModel selectTeacherByid(UidAndTenantIDParam param);

	/**
	 * 查询老师信息
	 * @param param
	 * @return
	 */
    PCTeacherInfoModel selectTeacherInfo1(UidAndTenantIDParam param);

	/**
	 * 通过运营id查询首页老师排行榜
	 * @param tenant_id
	 * @return
	 */
	List<TeacherRankingModel> selectTeacherRanking(String tenant_id);

	/**
	 * 通过运营id查询首页老师集合
	 * @return
	 */
	List<TeacherListModel> selectTeacherList(TeacherListParam data);

	/**
	 * 课程详情--教师信息
	 * @param uid
	 * @param tenant_id
	 * @return
	 */
	TeacherInfoModel selectTeacherInfo2(@Param("uid")String uid, @Param("tenant_id")String tenant_id);

	/**
	 * 名师详情--讲师简介
	 * @param uid
	 * @param tenant_id
	 * @return
	 */
	TopTeacherInfoModel selectTopTeacherInfo(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

	/**
	 * 名师资源
	 * @param tenant_id
	 * @return
	 */

	List<IndexTeacherModel> indexTeacher(String tenant_id);

	/**
	 * 名师资源列表
	 * @param parameter
	 * @return
	 */

	List<IndexTeacherListModel> indexTeacherList(IndexTeacherListParam parameter);

	/**
	 * 名师列表
	 * @param data
	 * @return
	 */
	List<TopTeacherListModel> selectTopTeacherList(TopTeacherListParam data);


}
