package com.qht.biz;

import com.qht.RequestObject;
import com.qht.dto.*;

import com.qht.entity.Tag;
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
     * @param tenant_id
     * @return
     */
    public List<BannerDto> selectBanner(String tenant_id,String type) {
        return studentMapper.selectBanner(tenant_id,type);
    }

    /**
     * 首页查询直播课程
     *
     * @param tenant_id
     * @return
     */
    public List<LiveClassDto> selectLiveClass(String tenant_id) {
        return studentMapper.selectLiveClass(tenant_id);
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
     * @param tenant_id
     * @return
     */
    public List<ListeningClassRankingDto> selectListeningClassRanking(String tenant_id) {
        return studentMapper.selectListeningClassRanking(tenant_id);
    }

    /**
     * 查询首页试听列表
     * @param tenant_id
     * @return
     */
    public List<ListeningClassListDto> selectListeningClassList(String tenant_id) {
        return studentMapper.selectListeningClassList(tenant_id);
    }

    /**
     * 查询首页老师排行榜
     * @param tenant_id
     * @return
     */
    public List<TeacherRankingDto> selectTeacherRanking(String tenant_id) {
        return studentMapper.selectTeacherRanking(tenant_id);
    }

    /**
     * 查询首页老师集合
     * @return
     */
    public List<TeacherListDto> selectTeacherList(TeacherListParameter data) {
        return studentMapper.selectTeacherList(data);
    }

    /**
     * 查询学生课程详情-课程包简介
     * @param uid
     * @param tenant_id
     * @return
     */
    public CourseIntroDto selectCourseIntro(String uid, String tenant_id) {

        return studentMapper.selectCourseIntro(uid,tenant_id);
    }

    /**
     * 课程详情--课程包体系
     * @param uid
     * @param tenant_id
     * @return
     */
    public List<CourseChapterDto> selectCourseChapter(String uid, String tenant_id) {
        return studentMapper.selectCourseChapter(uid,tenant_id);
    }

    /**
     * 课程详情--课程包评论
     * @return
     */
    public List<CourseEvaluationDto> selectCourseEvaluation(CourseEvaluationParameter data) {
        return studentMapper.selectCourseEvaluation(data);
    }
    public List<CourseEvaluationDto> selectCourseEvaluationGood(CourseEvaluationParameter data) {
        return studentMapper.selectCourseEvaluationGood(data);
    }
    public List<CourseEvaluationDto> selectCourseEvaluationMid(CourseEvaluationParameter data) {
        return studentMapper.selectCourseEvaluationMid(data);
    }
    public List<CourseEvaluationDto> selectCourseEvaluationBad(CourseEvaluationParameter data) {
        return studentMapper.selectCourseEvaluationBad(data);
    }

    /**
     * 课程详情--教师信息
     * @param uid
     * @param tenant_id
     * @return
     */
    public TeacherInfoDto selectTeacherInfo(String uid, String tenant_id) {
        return studentMapper.selectTeacherInfo(uid,tenant_id);
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
     * @param tenant_id
     * @return
     */
    public TopTeacherInfoDto selectTopTeacherInfo(String uid, String tenant_id) {
        return studentMapper.selectTopTeacherInfo(uid,tenant_id);
    }

    /**
     * 名师详情--全部课程
     * @param uid
     * @param tenant_id
     * @return
     */
    public List<TeacherCourseDto> selectTeacherCourse(String uid, String tenant_id) {
        return studentMapper.selectTeacherCourse(uid,tenant_id);
    }

    /**
     * 名师详情--评论列表
     * @param uid
     * @param tenant_id
     * @return
     */
    public List<TeacherEvaluationDto> selectTeacherEvaluation(String uid, String tenant_id) {
        return studentMapper.selectTeacherEvaluation(uid,tenant_id);
    }

    /**
     * 运营商--学校介绍
     * @param tenant_id
     * @return
     */
    public TenantSchoolDto selectTenantSchool(String tenant_id) {
        return studentMapper.selectTenantSchool(tenant_id);
    }

    /**
     * 运营商--画册
     * @param tenant_id
     * @return
     */
    public List<TenantAlbumDto> selectTenantAlbum(String tenant_id) {
        return studentMapper.selectTenantAlbum(tenant_id);
    }

    /**
     * 学生端-个人中心--首页--我的课程详情介绍
     * @param uid
     * @param tenant_id
     * @return
     */
    public List<IndexCourseDetailsDto> selectIndexCourseDetails(String uid, String tenant_id) {
        return studentMapper.selectIndexCourseDetails(uid,tenant_id);
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
     * @param tenant_id
     * @return
     */
    public StudentInfoDto studentInfo(String uid,String tenant_id){
        return  studentMapper.studentInfo(uid,tenant_id);
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
     * @param tenant_id
     * @return
     */
   public List<IndexFutureCoruseDto> indexFutureCoruse(String uid,String tenant_id){
       return studentMapper.indexFutureCoruse(uid,tenant_id);
   }

    /**
     * 名师资源
     * @param tenant_id
     * @return
     */
    public List<IndexTeacherDto> indexTeacher(String tenant_id){
       return  studentMapper.indexTeacher(tenant_id);
    }
    /**
     * 课程疑答
     * @param tenant_id
     * @return
     */
  public  List<IndexAnswerDto> indexAnswer(String tenant_id){
        return studentMapper.indexAnswer(tenant_id);
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

    /**
     * 学生端-个人中心--首页--兑换记录--课程详情
     * @param uid
     * @return
     */
    public List<MyIndexBuyRecordCourseDetailsDto> selectMyIndexBuyRecordDetails(String uid) {
        return studentMapper.selectMyIndexBuyRecordDetails(uid);
    }

    /**
     * 学生端-个人中心--首页--兑换记录--课程回看
     * @param data
     * @return
     */
    public List<MyIndexBuyRecordCourseBackDto> selectMyIndexBuyRecordCourseBack(MyIndexBuyRecordCourseBackParameter data) {

        return studentMapper.selectMyIndexBuyRecordCourseBack(data);
    }

    /**
     *学生端-个人中心--首页--我的收藏列表
     * @param data
     * @return
     */
    public List<MyIndexMycollectDto> selectMyIndexMycollect(MyIndexMycollectParameter data) {
        return studentMapper.selectMyIndexMycollect(data);
    }

    /**
     * 学生端-个人中心--首页--我的收藏列表--取消收藏
     * @param uid
     * @param student_id
     * @param tenant_id
     */
    public Integer updateMyIndexCancelcollect(String uid, String student_id, String tenant_id) {

        Integer num=studentMapper.updateMyIndexCancelcollect(uid,student_id,tenant_id);
        return num;
    }

    /**
     * app我的课程答疑
     * @param uid
     * @param tenant_id
     * @return
     */
    public List<IndexMyAnswerDto> selectIndexMyAnswer(String uid, String tenant_id) {
        return studentMapper.selectIndexMyAnswer(uid,tenant_id);
    }

    /**
     * app我的课程答疑--答疑详情
     * @param uid
     * @param tenant_id
     * @return
     */
    public IndexAnswerDetailsDto selectIndexAnswerDetails(String uid, String tenant_id) {
        return studentMapper.selectIndexAnswerDetails(uid,tenant_id);
    }

    /**
     * 打赏---先判断问题是否被解决
     * @param answer_id
     * @return
     */
    public Integer selectAnswerType(String answer_id) {
        return studentMapper.selectAnswerType(answer_id);
    }

    /**
     * 打赏--判断学生余额
     * @param student_id
     * @return
     */
    public Integer selectStudentBalance(String student_id) {
        return studentMapper.selectStudentBalance(student_id);
    }

    /**
     * 判断学生是否已经打赏
     * @param answer_id
     * @return
     */
    public Integer selectAnswerReward(String answer_id) {
        return studentMapper.selectAnswerReward(answer_id);
    }

    /**
     * 扣除学生的积分
     * @param student_id
     * @return
     */
    public Integer updateStudentBalanceByUid(String student_id,Integer value) {
        return studentMapper.updateStudentBalanceByUid(student_id,value);
    }

    /**
     * 增加老师的积分
     * @param teacher_id
     * @param value
     * @return
     */
    public Integer updateTeacherBalanceByUid(String teacher_id, Integer value) {
        return studentMapper.uodateTeacherBalanceByUid(teacher_id,value);
    }

    /**
     * 插入记录
     * @param uid
     * @param value
     * @param teacher_id
     * @param student_id
     * @return
     */
    public Integer insertStudentRecord(String uid, Integer value, String teacher_id, String student_id) {
        return studentMapper.insertStudentRecord(uid,value,teacher_id,student_id);
    }
    public Integer insertTeacherRecord(String uid, Integer value, String teacher_id) {
        return studentMapper.insertTeacherRecord(uid,value,teacher_id);
    }

    /**
     * 我的课程答疑--答疑详情-追问回答
     * @param data
     * @return
     */
    public Integer insertAppendAskAnswer(IndexAnswerDetailsAppendAnswerParameter data) {
        return studentMapper.indsertAppendAskAnswer(data);
    }
    /**
     * 个人中心学生信息
     * @param uid
     * @param tenant_id
     * @return
     */
    public AppMyStudentInfoDto appMyStudentInfo(String uid,String tenant_id){
        return studentMapper.appMyStudentInfo(uid,tenant_id);
    }
    /**
     * app修改头像
     * @param parameter
     * @return
     */
   public  Integer appUpdaetStudentHead(AppStudentParameter parameter){
        return studentMapper.appUpdaetStudentHead(parameter);
    }
    /**
     * app修改学生昵称
     * @param parameter
     * @return
     */
    public Integer appUpdaetStudentNickname(AppStudentParameter parameter){
        return studentMapper.appUpdaetStudentNickname(parameter);
    }
    /**
     * app修改学生密码
     * @param parameter
     * @return
     */
   public Integer  appUpdaetStudentPassword(AppStudentParameter parameter){
       return studentMapper.appUpdaetStudentPassword(parameter);
   }
    /**
     * 查看监护人信息
     * @param parameter
     * @return
     */
   public List<AppMyStudentGuardianDto>appMyStudentGuardian(AppStudentParameter parameter){
       return  studentMapper.appMyStudentGuardian(parameter);
   }
    /**
     * 查看兴趣标签
     * @param parameter
     * @return
     */
   public List<TagDto> appMyStudentInterest (AppStudentParameter parameter){
        return  studentMapper.appMyStudentInterest(parameter);
    }
}

