package com.qht.biz;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.StudentDto;
import com.qht.entity.Student;
import com.qht.mapper.StudentMapper;
import com.qht.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<BannerModel> selectBanner(String tenant_id,String type) {
        return studentMapper.selectBanner(tenant_id,type);
    }

    /**
     * 首页查询直播课程
     *
     * @param tenant_id
     * @return
     */

    public List<LiveClassModel> selectLiveClass(String tenant_id) {
        return studentMapper.selectLiveClass(tenant_id);
    }

    /**
     * 查询首页的免费课程
     * @return
     */

    public List<FreeClassModel> selectFreeClass(FreeClassParam data) {
        return studentMapper.selectFreeClass(data);
    }

    /**
     * 查询首页试听排行榜
     * @param tenant_id
     * @return
     */

    public List<ListeningClassRankingModel> selectListeningClassRanking(String tenant_id) {
        return studentMapper.selectListeningClassRanking(tenant_id);
    }

    /**
     * 查询首页试听列表
     * @param tenant_id
     * @return
     */

    public List<ListeningClassListModel> selectListeningClassList(String tenant_id) {
        return studentMapper.selectListeningClassList(tenant_id);
    }

    /**
     * 查询首页老师排行榜
     * @param tenant_id
     * @return
     */

    public List<TeacherRankingModel> selectTeacherRanking(String tenant_id) {
        return studentMapper.selectTeacherRanking(tenant_id);
    }

    /**
     * 查询首页老师集合
     * @return
     */

    public List<TeacherListModel> selectTeacherList(TeacherListParam data) {
        return studentMapper.selectTeacherList(data);
    }

    /**
     * 查询学生课程详情-课程包简介
     * @param uid
     * @param tenant_id
     * @return
     */

    public CourseIntroModel selectCourseIntro(String uid, String tenant_id) {

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

    public List<CourseEvaluationModel> selectCourseEvaluation(CourseEvaluationParam data) {
        return studentMapper.selectCourseEvaluation(data);
    }

    public List<CourseEvaluationModel> selectCourseEvaluationGood(CourseEvaluationParam data) {
        return studentMapper.selectCourseEvaluationGood(data);
    }

    public List<CourseEvaluationModel> selectCourseEvaluationMid(CourseEvaluationParam data) {
        return studentMapper.selectCourseEvaluationMid(data);
    }

    public List<CourseEvaluationModel> selectCourseEvaluationBad(CourseEvaluationParam data) {
        return studentMapper.selectCourseEvaluationBad(data);
    }

    /**
     * 课程详情--教师信息
     * @param uid
     * @param tenant_id
     * @return
     */

    public TeacherInfoModel selectTeacherInfo(String uid, String tenant_id) {
        return studentMapper.selectTeacherInfo(uid,tenant_id);
    }

    /**
     * 课程列表
     * @param data
     * @return
     */

    public List<CourseListModel> selectCourseList(CourseListParam data) {
        return studentMapper.selectCourseList(data);
    }

    /**
     * 名师列表
     * @param data
     * @return
     */

    public List<TopTeacherListModel> selectTopTeacherList(TopTeacherListParam data) {
        return studentMapper.selectTopTeacherList(data);
    }

    /**
     * 名师详情--讲师简介
     * @param uid
     * @param tenant_id
     * @return
     */

    public TopTeacherInfoModel selectTopTeacherInfo(String uid, String tenant_id) {
        return studentMapper.selectTopTeacherInfo(uid,tenant_id);
    }

    /**
     * 名师详情--全部课程
     * @param uid
     * @param tenant_id
     * @return
     */
    public List<TeacherCourseModel> selectTeacherCourse(String uid, String tenant_id) {
        return studentMapper.selectTeacherCourse(uid,tenant_id);
    }

    /**
     * 名师详情--评论列表
     * @param uid
     * @param tenant_id
     * @return
     */

    public List<TeacherEvaluationModel> selectTeacherEvaluation(String uid, String tenant_id) {
        return studentMapper.selectTeacherEvaluation(uid,tenant_id);
    }

    /**
     * 运营商--学校介绍
     * @return
     */


    public TenantSchoolModel selectTenantSchool(UidAndTenantIDParam param) {
        return studentMapper.selectTenantSchool(param);
    }

    /**
     * 运营商--画册
     * @param tenant_id
     * @return
     */

    public List<TenantAlbumModel> selectTenantAlbum(String tenant_id) {
        return studentMapper.selectTenantAlbum(tenant_id);
    }

    /**
     * 学生端-个人中心--首页--我的课程详情介绍
     * @param uid
     * @param tenant_id
     * @return
     */

    public List<IndexCourseDetailsModel> selectIndexCourseDetails(String uid, String tenant_id) {
        return studentMapper.selectIndexCourseDetails(uid,tenant_id);
    }

    /**
     * 消息
     * @param paramter
     * @return
     */


    public List<MyIndexMessageModel> selectMyIndexMessage(MyIndexMessageParam paramter) {
        return studentMapper.selectMyIndexMessage(paramter.getUid(), paramter.getTenant_id(), paramter.getIsread());
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
     * @return
     */

    public MyIndexMessageModel selectMessageById(UidAndTenantIDParam param) {
        return studentMapper.selectMessageById(param);
    }

    /**
     * 学生端-个人中心--首页--我的课程列表
     * @param data
     * @return
     */

    public List<MyIndexCourseModel> selectMyIndexCourse(MyIndexCourseParam data) {
        return studentMapper.selectMyIndexCourse(data);
    }

    /**
     *学生端-个人中心--首页--课程答疑
     * @param data
     * @return
     */

    public List<MyIndexCourseAnswerModel> selectMyIndexCourseAnswer(MyIndexCourseAnswerParam data) {
        return studentMapper.selectMyIndexCourseAnswer(data);
    }

    /**
     * 学生端-个人中心--首页--兑换记录
     * @param data
     * @return
     */

    public List<MyIndexBuyRecordModel> selectMyIndexBuyRecourd(MyIndexBuyRecordParam data) {
        return studentMapper.selectMyIndexBuyRecord(data);
    }




    /**
     * 學生信息
     * @param uid
     * @param tenant_id
     * @return
     */

    public StudentInfoModel studentInfo(String uid,String tenant_id){
        return  studentMapper.studentInfo(uid,tenant_id);
    }

    /**
     * 消費明細
     * @param parameter
     * @return
     */


    public List<MyIndexMyintegralDetailModel> myIndexMyintegralDetail(MyIndexMyintegralDetailParam parameter){
        return  studentMapper.myIndexMyintegralDetail(parameter);
    }

    /**
     * 近期合同
     * @param uid
     * @param tenant_id
     * @return
     */

   public List<IndexFutureCoruseModel> indexFutureCoruse(String uid,String tenant_id){
       return studentMapper.indexFutureCoruse(uid,tenant_id);
   }

    /**
     * 名师资源
     * @param tenant_id
     * @return
     */

    public List<IndexTeacherModel> indexTeacher(String tenant_id){
       return  studentMapper.indexTeacher(tenant_id);
    }
    /**
     * 课程疑答
     * @param tenant_id
     * @return
     */

  public  List<IndexAnswerModel> indexAnswer(String tenant_id){
        return studentMapper.indexAnswer(tenant_id);
  }
    /**
     * 课程列表
     * @param parameter
     * @return
     */

  public   List<IndexCoruseListModel> indexCoruseList(IndexCoruseListParam parameter){
        return studentMapper.indexCoruseList(parameter);
  }

    /**
     * 名师资源列表
     * @param parameter
     * @return
     */

  public   List<IndexTeacherListModel> indexTeacherList(IndexTeacherListParam parameter){
        return studentMapper.indexTeacherList(parameter);
  }

    /**
     * 学生端-个人中心--首页--兑换记录--课程详情
     * @param uid
     * @return
     */

    public List<MyIndexBuyRecordCourseDetailsModel> selectMyIndexBuyRecordDetails(String uid) {
        return studentMapper.selectMyIndexBuyRecordDetails(uid);
    }

    /**
     * 学生端-个人中心--首页--兑换记录--课程回看
     * @param data
     * @return
     */

    public List<MyIndexBuyRecordCourseBackModel> selectMyIndexBuyRecordCourseBack(MyIndexBuyRecordCourseBackParam data) {

        return studentMapper.selectMyIndexBuyRecordCourseBack(data);
    }

    /**
     *学生端-个人中心--首页--我的收藏列表
     * @param data
     * @return
     */

    public List<MyIndexMycollectModel> selectMyIndexMycollect(MyIndexMycollectParam data) {
        return studentMapper.selectMyIndexMycollect(data);
    }

    /**
     * 学生端-个人中心--首页--我的收藏列表--取消收藏
     */
    public Integer updateMyIndexCancelcollect(MyIndexCanceCollectParam param) {

        Integer num=studentMapper.updateMyIndexCancelcollect(param);
        return num;
    }

    /**
     * app我的课程答疑
     * @param uid
     * @param tenant_id
     * @return
     */

    public List<IndexMyAnswerModel> selectIndexMyAnswer(String uid, String tenant_id) {
        return studentMapper.selectIndexMyAnswer(uid,tenant_id);
    }

    /**
     * app我的课程答疑--答疑详情
     * @param uid
     * @param tenant_id
     * @return
     */

    public IndexAnswerDetailsModel selectIndexAnswerDetails(String uid, String tenant_id) {
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

    public Integer insertAppendAskAnswer(IndexAnswerDetailsAppendAnswerParam data) {
        return studentMapper.indsertAppendAskAnswer(data);
    }
    /**
     * 个人中心学生信息
     * @param uid
     * @param tenant_id
     * @return
     */

    public AppMyStudentInfoModel appMyStudentInfo(String uid,String tenant_id){
        return studentMapper.appMyStudentInfo(uid,tenant_id);
    }
    /**
     * app修改头像
     * @param parameter
     * @return
     */

   public  Integer appUpdaetStudentHead(AppStudentParam parameter){
        return studentMapper.appUpdaetStudentHead(parameter);
    }
    /**
     * app修改学生昵称
     * @param parameter
     * @return
     */

    public Integer appUpdaetStudentNickname(AppStudentParam parameter){
        return studentMapper.appUpdaetStudentNickname(parameter);
    }
    /**
     * app修改学生密码
     * @param parameter
     * @return
     */

   public Integer  appUpdaetStudentPassword(AppStudentParam parameter){
       return studentMapper.appUpdaetStudentPassword(parameter);
   }
    /**
     * 查看监护人信息
     * @param parameter
     * @return
     */

   public List<AppMyStudentGuardianModel>appMyStudentGuardian(AppStudentParam parameter){
       return  studentMapper.appMyStudentGuardian(parameter);
   }
    /**
     * 查看兴趣标签
     * @param parameter
     * @return
     */

   public List<TagModel> appMyStudentInterest (AppStudentParam parameter){
        return  studentMapper.appMyStudentInterest(parameter);
    }

    /**
     * 学生端-个人中心--首页--我的课时详情介绍
     * @param param
     * @return
     */
    public MyIndexCourseDetailsModel selectMyIndexCourseDetails(UidAndTenantIDParam param) {
        return studentMapper.selectMyIndexCourseDetails(param);
    }
}

