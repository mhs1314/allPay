package com.qht.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.TeacherDto;
import com.qht.entity.Teacher;
import com.qht.mapper.TeacherMapper;
import com.qht.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   public TeacherDetailsModel teacherDetails(String uid,String tid){
       return teacherMapper.teacherDetails(uid,tid);
   }
    /**
     * 名师详情-所有课程
     * @param uid
     * @param tid
     * @return
     */
   public List<AppTeacherCourseModel>  appTeacherCourseDto  (String uid,String tid){
        return teacherMapper.appTeacherCourseDto(uid,tid);
    }

    /**
     * 名师详情-所有评论
     * @param uid
     * @param tid
     * @param eval
     * @return
     */
   public  List<AppTeacherEvaluationModel> teacherEvaluation(String uid,String tid,Integer eval){
       return teacherMapper.teacherEvaluation(uid,tid,eval);
   }

	/**
	 * app个人中心教室信息
	 */
	public AppSelectTeacherByidModel selectTeacherByid(UidAndTenantIDParam param) {
		return teacherMapper.selectTeacherByid(param);
	}

    /**
     * 查询老师信息
     * @param param
     * @return
     */
    public PCTeacherInfoModel selectTeacherInfo1(UidAndTenantIDParam param) {
        return teacherMapper.selectTeacherInfo1(param);
    }

	/**
	 * 查询首页老师排行榜
	 * @param tenant_id
	 * @return
	 */
	public List<TeacherRankingModel> selectTeacherRanking(String tenant_id) {
		return teacherMapper.selectTeacherRanking(tenant_id);
	}

	/**
	 * 查询首页老师集合
	 * @return
	 */

	public List<TeacherListModel> selectTeacherList(TeacherListParam data) {
		return teacherMapper.selectTeacherList(data);
	}

	/**
	 * 课程详情--教师信息
	 * @param uid
	 * @param tenant_id
	 * @return
	 */

	public TeacherInfoModel selectTeacherInfo2(String uid, String tenant_id) {
		return teacherMapper.selectTeacherInfo2(uid,tenant_id);
	}
	/**
	 * 名师详情--讲师简介
	 * @param uid
	 * @param tenant_id
	 * @return
	 */
	public TopTeacherInfoModel selectTopTeacherInfo(String uid, String tenant_id) {
		return teacherMapper.selectTopTeacherInfo(uid,tenant_id);
	}

	/**
	 * 名师资源
	 * @param tenant_id
	 * @return
	 */

	public List<IndexTeacherModel> indexTeacher(String tenant_id){
		return  teacherMapper.indexTeacher(tenant_id);
	}

	/**
	 * 名师资源列表
	 * @param parameter
	 * @return
	 */

	public   List<IndexTeacherListModel> indexTeacherList(IndexTeacherListParam parameter){
		return teacherMapper.indexTeacherList(parameter);
	}

	/**
	 * 名师列表
	 * @param data
	 * @return
	 */

	public List<TopTeacherListModel> selectTopTeacherList(TopTeacherListParam data) {
		return teacherMapper.selectTopTeacherList(data);
	}


}