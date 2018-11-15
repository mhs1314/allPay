package com.qht.mapper;

import com.qht.dto.*;
import com.qht.entity.Student;

import com.qht.entity.Tag;
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
    List<BannerDto> selectBanner(@Param("tenant_id") String tenant_id,@Param("type") String type);

    /**
     * 通过运营id查询首页直播课程
     * @param tenant_id
     * @return
     */
    List<LiveClassDto> selectLiveClass(String tenant_id);

    /**
     * 通过pkg_subject_id，pkg_grade_id，tenant_id查询首页免费课程
     * @return
     */
    List<FreeClassDto> selectFreeClass(FreeClassParameter data);

    /**
     * 通过运营id查询首页试听排行榜
     * @param tenant_id
     * @return
     */
    List<ListeningClassRankingDto> selectListeningClassRanking(String tenant_id);

    /**
     * 通过运营id查询首页试听列表
     * @param tenant_id
     * @return
     */
    List<ListeningClassListDto> selectListeningClassList(String tenant_id);

    /**
     * 通过运营id查询首页老师排行榜
     * @param tenant_id
     * @return
     */
    List<TeacherRankingDto> selectTeacherRanking(String tenant_id);

    /**
     * 通过运营id查询首页老师集合
     * @param tenant_id
     * @return
     */
    List<TeacherListDto> selectTeacherList(String tenant_id);

    /**
     * 查询学生课程详情-课程包简介
     * @param uid
     * @param tenant_id
     * @return
     */
    CourseIntroDto selectCourseIntro(@Param("uid") String uid,@Param("tenant_id") String tenant_id);

    /**
     * 课程详情--课程包体系
     * @param uid
     * @param tenant_id
     * @return
     */
    List<CourseChapterDto> selectCourseChapter(@Param("uid")String uid, @Param("tenant_id")String tenant_id);

    /**
     * 课程详情--课程包评论
     * @param uid
     * @param tenant_id
     * @return
     */
    List<CourseEvaluationDto> selectCourseEvaluation(@Param("uid")String uid, @Param("tenant_id")String tenant_id);

    /**
     * 课程详情--教师信息
     * @param uid
     * @param tenant_id
     * @return
     */
    TeacherInfoDto selectTeacherInfo(@Param("uid")String uid, @Param("tenant_id")String tenant_id);

    /**
     * 课程列表
     * @param data
     * @return
     */
    List<CourseListDto> selectCourseList(CourseListParameter data);

    /**
     * 名师列表
     * @param data
     * @return
     */
    List<TopTeacherListDto> selectTopTeacherList(TopTeacherListParameter data);

    /**
     * 名师详情--讲师简介
     * @param uid
     * @param tenant_id
     * @return
     */
    List<TopTeacherInfoDto> selectTopTeacherInfo(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

    /**
     * 名师详情--全部课程
     * @param uid
     * @param tenant_id
     * @return
     */
    List<TeacherCourseDto> selectTeacherCourse(@Param("uid")String uid, @Param("tenant_id") String tenant_id);

    /**
     * 名师详情--评论列表
     * @param uid
     * @param tenant_id
     * @return
     */
    List<TeacherEvaluationDto> selectTeacherEvaluation(@Param("uid")String uid, @Param("tenant_id") String tenant_id);

    /**
     * 运营商--学校介绍
     * @param tenant_id
     * @return
     */
    TenantSchoolDto selectTenantSchool(String tenant_id);

    /**
     * 运营商--画册
     * @param tenant_id
     * @return
     */
    TenantAlbumDto selectTenantAlbum(String tenant_id);

    /**
     * 学生端-个人中心--首页--我的课程详情介绍
     * @param uid
     * @param tenant_id
     * @return
     */
    List<IndexCourseDetailsDto> selectIndexCourseDetails(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

    /**
     * 学生端-个人中心--首页--我的课程列表
     * @param data
     * @return
     */
    List<MyIndexCourseDto> selectMyIndexCourse(MyIndexCourseParameter data);

    /**
     * 学生端-个人中心--首页--课程答疑
     * @param data
     * @return
     */
    List<MyIndexCourseAnswerDto> selectMyIndexCourseAnswer(MyIndexCourseAnswerParameter data);

    /**
     * 消息
     * @param uid
     * @param tenant_id
     * @param isread
     * @return
     */
    List<MyIndexMessageDto> selectMyIndexMessage(@Param("uid")String uid,@Param("tenant_id")String tenant_id,@Param("isread")String isread);

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
    MyIndexMessageDto selectMessageById(String uid);

    /**
     * 学生端-个人中心--首页--兑换记录
     * @param data
     * @return
     */
    List<MyIndexBuyRecordDto> selectMyIndexBuyRecord(MyIndexBuyRecordParameter data);
    /**
     * 查詢學生信息
     * @param uid
     * @param tenant_id
     * @return
     */
    StudentInfoDto studentInfo(@Param("uid")String uid,@Param("tenant_id")String tenant_id);

    /**
     * 消费记录
     * @param parameter
     * @return
     */
    List<MyIndexMyintegralDetailDto> myIndexMyintegralDetail(MyIndexMyintegralDetailParameter parameter);

    /**
     * 近期合同
     * @param uid
     * @param tenant_id
     * @return
     */
    List<IndexFutureCoruseDto> indexFutureCoruse(@Param("uid")String uid,@Param("tenant_id")String tenant_id);

    /**
     * 名师资源
     * @param tenant_id
     * @return
     */
    List<IndexTeacherDto> indexTeacher(String tenant_id);

    /**
     * 课程疑答
     * @param tenant_id
     * @return
     */
    List<IndexAnswerDto> indexAnswer(String tenant_id);

    /**
     * 课程列表
     * @param parameter
     * @return
     */
    List<IndexCoruseListDto> indexCoruseList(IndexCoruseListParameter parameter);
    /**
     * 名师资源列表
     * @param parameter
     * @return
     */
    List<IndexTeacherListDto> indexTeacherList(IndexTeacherListParameter parameter);

    /**
     * 学生端-个人中心--首页--兑换记录--课程详情
     * @param uid
     * @return
     */
    List<MyIndexBuyRecordCourseDetailsDto> selectMyIndexBuyRecordDetails(String uid);

    /**
     * 学生端-个人中心--首页--兑换记录--课程回看
     * @param data
     * @return
     */
    List<MyIndexBuyRecordCourseBackDto> selectMyIndexBuyRecordCourseBack(MyIndexBuyRecordCourseBackParameter data);

    /**
     * 学生端-个人中心--首页--我的收藏列表
     * @param data
     * @return
     */
    List<MyIndexMycollectDto> selectMyIndexMycollect(MyIndexMycollectParameter data);

    /**
     * 学生端-个人中心--首页--我的收藏列表--取消收藏
     * @param uid
     * @param student_id
     * @param tenant_id
     */
    Integer updateMyIndexCancelcollect(@Param("uid") String uid, @Param("student_id") String student_id, @Param("tenant_id") String tenant_id);

    /**
     * app我的课程答疑
     * @param uid
     * @param tenant_id
     * @return
     */
    List<IndexMyAnswerDto> selectIndexMyAnswer(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

    /**
     * app我的课程答疑--答疑详情
     * @param uid
     * @param tenant_id
     * @return
     */
    IndexAnswerDetailsDto selectIndexAnswerDetails(@Param("uid") String uid, @Param("tenant_id") String tenant_id);

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
    Integer indsertAppendAskAnswer(IndexAnswerDetailsAppendAnswerParameter data);

    /**
     * 个人中心学生信息
     * @param uid
     * @param tenant_id
     * @return
     */
    AppMyStudentInfoDto appMyStudentInfo(@Param("uid")String uid,@Param("tenant_id")String tenant_id);
    /**
     * app修改头像
     * @param parameter
     * @return
     */
    Integer appUpdaetStudentHead(AppStudentParameter parameter);

    /**
     * app修改学生昵称
     * @param parameter
     * @return
     */
    Integer appUpdaetStudentNickname(AppStudentParameter parameter);
    /**
     * app修改学生密码
     * @param parameter
     * @return
     */
   Integer  appUpdaetStudentPassword(AppStudentParameter parameter);

    /**
     * 查看监护人信息
     * @param parameter
     * @return
     */
    List<AppMyStudentGuardianDto>appMyStudentGuardian(AppStudentParameter parameter);

    /**
     * 查看兴趣标签
     * @param parameter
     * @return
     */
   List<TagDto> appMyStudentInterest (AppStudentParameter parameter);
}
