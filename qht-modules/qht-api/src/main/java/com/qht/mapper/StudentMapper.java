package com.qht.mapper;

import com.qht.dto.StudentDto;
import com.qht.entity.Student;
import com.qht.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 学生
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface StudentMapper extends Mapper<Student> {
    /**
     * 学生登陆
     * @param account
     * @param password
     * @return
     */
    StudentDto studentLogin(@Param("account") String account, @Param("password") String password);

    /**
     * 通过运营id查询首页banner
     * @param tenant_id
     * @return
     */
    List<BannerModel> selectBanner(@Param("tenant_id") String tenant_id,@Param("type") String type);

    /**
     * 通过运营id查询首页直播课程
     * @param tenant_id
     * @return
     */
    List<LiveClassModel> selectLiveClass(String tenant_id);

    /**
     * 通过pkg_subject_id，pkg_grade_id，tenant_id查询首页免费课程
     * @return
     */
    List<FreeClassModel> selectFreeClass(FreeClassParam data);

    /**
     * 通过运营id查询首页试听排行榜
     * @param tenant_id
     * @return
     */
    List<ListeningClassRankingModel> selectListeningClassRanking(String tenant_id);

    /**
     * 通过运营id查询首页试听列表
     * @param tenant_id
     * @return
     */
    List<ListeningClassListModel> selectListeningClassList(String tenant_id);

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
     * 查询学生课程详情-课程包简介
     * @param uid
     * @param tenant_id
     * @return
     */
    CourseIntroModel selectCourseIntro(@Param("uid") String uid,@Param("tenant_id") String tenant_id);

    /**
     * 课程详情--课程包体系
     * @param uid
     * @param tenant_id
     * @return
     */
    List<CourseChapterModel> selectCourseChapter(@Param("uid")String uid, @Param("tenant_id")String tenant_id);

    /**
     * 课程详情--课程包评论
     * @return
     */
    List<CourseEvaluationModel> selectCourseEvaluation(CourseEvaluationParam data);
    List<CourseEvaluationModel> selectCourseEvaluationGood(CourseEvaluationParam data);
    List<CourseEvaluationModel> selectCourseEvaluationBad(CourseEvaluationParam data);
    List<CourseEvaluationModel> selectCourseEvaluationMid(CourseEvaluationParam data);

    /**
     * 课程详情--教师信息
     * @param uid
     * @param tenant_id
     * @return
     */
    TeacherInfoModel selectTeacherInfo(@Param("uid")String uid, @Param("tenant_id")String tenant_id);

    /**
     * 课程列表
     * @param data
     * @return
     */
    List<CourseListModel> selectCourseList(CourseListParam data);

    /**
     * 名师列表
     * @param data
     * @return
     */
    List<TopTeacherListModel> selectTopTeacherList(TopTeacherListParam data);

    /**
     * 名师详情--讲师简介
     * @param uid
     * @param tenant_id
     * @return
     */

    TopTeacherInfoModel selectTopTeacherInfo(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

    /**
     * 名师详情--全部课程
     * @param uid
     * @param tenant_id
     * @return
     */

    List<TeacherCourseModel> selectTeacherCourse(@Param("uid")String uid, @Param("tenant_id") String tenant_id);

    /**
     * 名师详情--评论列表
     * @param uid
     * @param tenant_id
     * @return
     */

    List<TeacherEvaluationModel> selectTeacherEvaluation(@Param("uid")String uid, @Param("tenant_id") String tenant_id);

    /**
     * 运营商--学校介绍
     * @return
     */

    TenantSchoolModel selectTenantSchool(UidAndTenantIDParam param);

    /**
     * 运营商--画册
     * @param tenant_id
     * @return
     */

    List<TenantAlbumModel> selectTenantAlbum(String tenant_id);

    /**
     * 学生端-个人中心--首页--我的课程详情介绍
     * @param uid
     * @param tenant_id
     * @return
     */

    List<IndexCourseDetailsModel> selectIndexCourseDetails(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

    /**
     * 学生端-个人中心--首页--我的课程列表
     * @param data
     * @return
     */

    List<MyIndexCourseModel> selectMyIndexCourse(MyIndexCourseParam data);

    /**
     * 学生端-个人中心--首页--课程答疑
     * @param data
     * @return
     */

    List<MyIndexCourseAnswerModel> selectMyIndexCourseAnswer(MyIndexCourseAnswerParam data);

    /**
     * 消息
     * @param uid
     * @param tenant_id
     * @param isread
     * @return
     */

    List<MyIndexMessageModel> selectMyIndexMessage(@Param("uid")String uid,@Param("tenant_id")String tenant_id,@Param("isread")String isread);

    /**
     * 刪除消息
     * @param uid
     * @return
     */
    Integer deleteMessage(String uid);

    /**
     * 查詢消息
     * @param uid
     * @return
     */

    MyIndexMessageModel selectMessageById(UidAndTenantIDParam param);

    /**
     * 学生端-个人中心--首页--兑换记录
     * @param data
     * @return
     */

    List<MyIndexBuyRecordModel> selectMyIndexBuyRecord(MyIndexBuyRecordParam data);
    /**
     * 查詢學生信息
     * @param uid
     * @param tenant_id
     * @return
     */

    StudentInfoModel studentInfo(@Param("uid")String uid,@Param("tenant_id")String tenant_id);

    /**
     * 消费记录
     * @param parameter
     * @return
     */

    List<MyIndexMyintegralDetailModel> myIndexMyintegralDetail(MyIndexMyintegralDetailParam parameter);

    /**
     * 近期合同
     * @param uid
     * @param tenant_id
     * @return
     */

    List<IndexFutureCoruseModel> indexFutureCoruse(@Param("uid")String uid,@Param("tenant_id")String tenant_id);

    /**
     * 名师资源
     * @param tenant_id
     * @return
     */

    List<IndexTeacherModel> indexTeacher(String tenant_id);

    /**
     * 课程疑答
     * @param tenant_id
     * @return
     */

    List<IndexAnswerModel> indexAnswer(String tenant_id);

    /**
     * 课程列表
     * @param parameter
     * @return
     */

    List<IndexCoruseListModel> indexCoruseList(IndexCoruseListParam parameter);
    /**
     * 名师资源列表
     * @param parameter
     * @return
     */

    List<IndexTeacherListModel> indexTeacherList(IndexTeacherListParam parameter);

    /**
     * 学生端-个人中心--首页--兑换记录--课程详情
     * @param uid
     * @return
     */

    List<MyIndexBuyRecordCourseDetailsModel> selectMyIndexBuyRecordDetails(String uid);

    /**
     * 学生端-个人中心--首页--兑换记录--课程回看
     * @param data
     * @return
     */

    List<MyIndexBuyRecordCourseBackModel> selectMyIndexBuyRecordCourseBack(MyIndexBuyRecordCourseBackParam data);

    /**
     * 学生端-个人中心--首页--我的收藏列表
     * @param data
     * @return
     */

    List<MyIndexMycollectModel> selectMyIndexMycollect(MyIndexMycollectParam data);

    /**
     * 学生端-个人中心--首页--我的收藏列表--取消收藏
     */
    Integer updateMyIndexCancelcollect(MyIndexCanceCollectParam param);

    /**
     * app我的课程答疑
     * @param uid
     * @param tenant_id
     * @return
     */

    List<IndexMyAnswerModel> selectIndexMyAnswer(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

    /**
     * app我的课程答疑--答疑详情
     * @param uid
     * @param tenant_id
     * @return
     */

    IndexAnswerDetailsModel selectIndexAnswerDetails(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

    /**
     * 打赏---先判断问题是否被解决
     * @param answer_id
     * @return
     */
    Integer selectAnswerType(String answer_id);

    /**
     * 打赏---判断学生余额
     * @param student_id
     * @return
     */
    Integer selectStudentBalance(String student_id);

    /**
     * 判断学生是否已经打赏
     * @param answer_id
     * @return
     */
    Integer selectAnswerReward(String answer_id);

    /**
     * 扣除学生积分
     * @param student_id
     * @return
     */
    Integer updateStudentBalanceByUid(@Param("student_id") String student_id,@Param("value") Integer value);

    /**
     * 增加老师的积分
     * @param teacher_id
     * @param value
     * @return
     */
    Integer uodateTeacherBalanceByUid(@Param("teacher_id")String teacher_id, @Param("value")Integer value);

    /**
     * 插入记录
     * @param uid
     * @param value
     * @param teacher_id
     * @param student_id
     * @return
     */
    Integer insertStudentRecord(@Param("uid") String uid,@Param("value") Integer value, @Param("teacher_id")String teacher_id, @Param("student_id")String student_id);
    Integer insertTeacherRecord(@Param("uid") String uid,@Param("value") Integer value, @Param("teacher_id")String teacher_id);

    /**
     * 我的课程答疑--答疑详情-追问回答
     * @param data
     * @return
     */

    Integer indsertAppendAskAnswer(IndexAnswerDetailsAppendAnswerParam data);

    /**
     * 个人中心学生信息
     * @param uid
     * @param tenant_id
     * @return
     */

    AppMyStudentInfoModel appMyStudentInfo(@Param("uid")String uid,@Param("tenant_id")String tenant_id);
    /**
     * app修改头像
     * @param parameter
     * @return
     */

    Integer appUpdaetStudentHead(AppStudentParam parameter);

    /**
     * app修改学生昵称
     * @param parameter
     * @return
     */

    Integer appUpdaetStudentNickname(AppStudentParam parameter);
    /**
     * app修改学生密码
     * @param parameter
     * @return
     */

   Integer  appUpdaetStudentPassword(AppStudentParam parameter);

    /**
     * 查看监护人信息
     * @param parameter
     * @return
     */

    List<AppMyStudentGuardianModel>appMyStudentGuardian(AppStudentParam parameter);

    /**
     * 查看兴趣标签
     * @param parameter
     * @return
     */

   List<TagModel> appMyStudentInterest (AppStudentParam parameter);

    /**
     * 学生端-个人中心--首页--我的课时详情介绍
     * @param param
     * @return
     */
    MyIndexCourseDetailsModel selectMyIndexCourseDetails(UidAndTenantIDParam param);
}
