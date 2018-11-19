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
     * 教师|端首页--我的课程
     * @param data
     * @return
     */
    public List<IndexMyCourseModel> selectIndexMyCourseDto(IndexMyCourseParam data) {
        return teacherMapper.selectIndexMyCourseDto(data);
    }

    /**
     * 教师端首页--我的课程包
     * @param data
     * @return
     */
    public List<IndexMyCourseListModel> selectIndexMyCourseList(IndexMyCourseListParam data) {
        return teacherMapper.selectIndexMyCourseList(data);
    }
	
	/**
	 * 教师端首页--课程答疑列表
	 * @param param
	 * @return
	 */
	public List<IndexCourseAnswerModel> selectIndexCourseAnswer(IndexCourseAnswerParam param) {
		return teacherMapper.selectIndexCourseAnswer(param);
	}
	/**
	 * 教师端首页--我的消息
	 * @param param
	 * @return
	 */
	public List<IndexMessageModel> selectIndexMessage(IndexMessageParam param) {
		
		return teacherMapper.selectIndexMessage(param);
	}
	/**
	 * app个人中心教室信息
	 */
	public AppSelectTeacherByidModel selectTeacherByid(UidAndTenantIDParam param) {
		return teacherMapper.selectTeacherByid(param);
	}
}