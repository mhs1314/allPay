package com.qht.biz;

import com.qht.RequestObject;
import com.qht.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Student;
import com.qht.mapper.StudentMapper;

import java.util.List;

/**
 * 学生
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class StudentBiz extends BaseBiz<StudentMapper,Student> {


    @Autowired
    private StudentMapper studentMapper;

    /**
     * login查询学生
     *
     * @param account
     * @param password
     * @return
     */
    public StudentDto studentLogin(String account, String password) {
        return studentMapper.studentLogin(account, password);
    }

    /**
     * 首页查询banner
     *
     * @param tenantId
     * @return
     */
    public List<BannerDto> selectBanner(String tenantId,String type) {
        return studentMapper.selectBanner(tenantId,type);
    }

    /**
     * 首页查询直播课程
     *
     * @param tenantId
     * @return
     */
    public List<LiveClassDto> selectLiveClass(String tenantId) {
        return studentMapper.selectLiveClass(tenantId);
    }

    /**
     * 查询首页的免费课程
     * @return
     */
    public List<FreeClassDto> selectFreeClass(FreeClassParameter data) {
        return studentMapper.selectFreeClass(data);
    }

    /**
     * 查询首页试听排行榜
     * @param tenantId
     * @return
     */
    public List<ListeningClassRankingDto> selectListeningClassRanking(String tenantId) {
        return studentMapper.selectListeningClassRanking(tenantId);
    }

    /**
     * 查询首页试听列表
     * @param tenantId
     * @return
     */
    public List<ListeningClassListDto> selectListeningClassList(String tenantId) {
        return studentMapper.selectListeningClassList(tenantId);
    }

    /**
     * 查询首页老师排行榜
     * @param tenantId
     * @return
     */
    public List<TeacherRankingDto> selectTeacherRanking(String tenantId) {
        return studentMapper.selectTeacherRanking(tenantId);
    }

    /**
     * 查询首页老师集合
     * @param tenantId
     * @return
     */
    public List<TeacherListDto> selectTeacherList(String tenantId) {
        return studentMapper.selectTeacherList(tenantId);
    }

    /**
     * 查询学生课程详情-课程包简介
     * @param uid
     * @param tenantId
     * @return
     */
    public CourseIntroDto selectCourseIntro(String uid, String tenantId) {

        return studentMapper.selectCourseIntro(uid,tenantId);
    }

    /**
     * 课程详情--课程包体系
     * @param uid
     * @param tenantId
     * @return
     */
    public List<CourseChapterDto> selectCourseChapter(String uid, String tenantId) {
        return studentMapper.selectCourseChapter(uid,tenantId);
    }

    /**
     * 课程详情--课程包评论
     * @param uid
     * @param tenantId
     * @return
     */
    public List<CourseEvaluationDto> selectCourseEvaluation(String uid, String tenantId) {
        return studentMapper.selectCourseEvaluation(uid,tenantId);
    }

    /**
     * 课程详情--教师信息
     * @param uid
     * @param tenantId
     * @return
     */
    public TeacherInfoDto selectTeacherInfo(String uid, String tenantId) {
        return studentMapper.selectTeacherInfo(uid,tenantId);
    }

    /**
     * 课程列表
     * @param data
     * @return
     */
    public List<CourseListDto> selectCourseList(CourseListParameter data) {
        return studentMapper.selectCourseList(data);
    }

    /**
     * 名师列表
     * @param data
     * @return
     */
    public List<TopTeacherListDto> selectTopTeacherList(TopTeacherListParameter data) {
        return studentMapper.selectTopTeacherList(data);
    }

    /**
     * 名师详情--讲师简介
     * @param uid
     * @param tenantId
     * @return
     */
    public List<TopTeacherInfoDto> selectTopTeacherInfo(String uid, String tenantId) {
        return studentMapper.selectTopTeacherInfo(uid,tenantId);
    }

    /**
     * 名师详情--全部课程
     * @param uid
     * @param tenantId
     * @return
     */
    public List<TeacherCourseDto> selectTeacherCourse(String uid, String tenantId) {
        return studentMapper.selectTeacherCourse(uid,tenantId);
    }

    /**
     * 名师详情--评论列表
     * @param uid
     * @param tenantId
     * @return
     */
    public List<TeacherEvaluationDto> selectTeacherEvaluation(String uid, String tenantId) {
        return studentMapper.selectTeacherEvaluation(uid,tenantId);
    }

    /**
     * 运营商--学校介绍
     * @param tenantId
     * @return
     */
    public TenantSchoolDto selectTenantSchool(String tenantId) {
        return studentMapper.selectTenantSchool(tenantId);
    }

    /**
     * 运营商--画册
     * @param tenantId
     * @return
     */
    public TenantAlbumDto selectTenantAlbum(String tenantId) {
        return studentMapper.selectTenantAlbum(tenantId);
    }

    /**
     * 学生端-个人中心--首页--我的课程详情介绍
     * @param uid
     * @param tenantId
     * @return
     */
    public List<IndexCourseDetailsDto> selectIndexCourseDetails(String uid, String tenantId) {
        return studentMapper.selectIndexCourseDetails(uid,tenantId);
    }

    /**
     * 消息
     * @param paramter
     * @return
     */
    public List<MyIndexMessageDto> selectMyIndexMessage(RequestObject<MyIndexMessageParamter> paramter) {
        return studentMapper.selectMyIndexMessage(paramter.getData().getUid(), paramter.getData().getTenant_id(), paramter.getData().getIsread());
    }

    /**
     * 刪除消息
     *
     * @param id
     * @return
     */
    public Integer deleteMessage(String id) {
        return studentMapper.deleteMessage(id);
    }

    /**
     * 查詢信息
     *
     * @param uid
     * @return
     */
    public MyIndexMessageDto selectMessageById(String uid) {
        return studentMapper.selectMessageById(uid);
    }

    /**
     * 学生端-个人中心--首页--我的课程列表
     * @param data
     * @return
     */
    public List<MyIndexCourseDto> selectMyIndexCourse(MyIndexCourseParameter data) {
        return studentMapper.selectMyIndexCourse(data);
    }

    /**
     *学生端-个人中心--首页--课程答疑
     * @param data
     * @return
     */
    public List<MyIndexCourseAnswerDto> selectMyIndexCourseAnswer(MyIndexCourseAnswerParameter data) {
        return studentMapper.selectMyIndexCourseAnswer(data);
    }

    /**
     * 学生端-个人中心--首页--兑换记录
     * @param data
     * @return
     */
    public List<MyIndexBuyRecordDto> selectMyIndexBuyRecourd(MyIndexBuyRecordParameter data) {
        return studentMapper.selectMyIndexBuyRecord(data);
    }




    /**
     * 學生信息
     * @param uid
     * @param tid
     * @return
     */
    public StudentInfoDto studentInfo(String uid,String tid){
        return  studentMapper.studentInfo(uid,tid);
    }

    /**
     * 消費明細
     * @param parameter
     * @return
     */
    public List<MyIndexMyintegralDetailDto> myIndexMyintegralDetail(RequestObject<MyIndexMyintegralDetailParameter> parameter){
        return  studentMapper.myIndexMyintegralDetail(parameter.getData());
    }

    /**
     * 近期合同
     * @param uid
     * @param tid
     * @return
     */
   public List<IndexFutureCoruseDto> indexFutureCoruse(String uid,String tid){
       return studentMapper.indexFutureCoruse(uid,tid);
   }

    /**
     * 名师资源
     * @param tid
     * @return
     */
    public List<IndexTeacherDto> indexTeacher(String tid){
       return  studentMapper.indexTeacher(tid);
    }
    /**
     * 课程疑答
     * @param tid
     * @return
     */
  public  List<IndexAnswerDto> indexAnswer(String tid){
        return studentMapper.indexAnswer(tid);
  }
    /**
     * 课程列表
     * @param parameter
     * @return
     */
  public   List<IndexCoruseListDto> indexCoruseList(IndexCoruseListParameter parameter){
        return studentMapper.indexCoruseList(parameter);
    }

    /**
     * 名师资源列表
     * @param parameter
     * @return
     */
  public   List<IndexTeacherListDto> indexTeacherList(IndexTeacherListParameter parameter){
        return studentMapper.indexTeacherList(parameter);
    }
}

