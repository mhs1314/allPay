package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 学生
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface StudentService {
    /**学生端首页*/
    /**
     * 学生登陆的获取token
     * @param requestObject
     * @return
     */
    public ResultObject<StudentDto> login(RequestObject<LoginInfoDto> requestObject);

    /**
     * 获取首页广告信息
     * @param req
     * @return
     */
    public ResultObject<List<BannerDto>> banner(HttpServletRequest req);
    /**
     * 获取首页广告信息--App
     * @param req
     * @return
     */
    public ResultObject<List<BannerDto>> indexBanner(HttpServletRequest req);
    /**
     * 获取首页的直播课程
     * @param req
     * @return
     */
    public ResultObject<List<LiveClassDto>> liveClass(HttpServletRequest req);

    /**
     * 获取首页免费课程
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<FreeClassDto>> freeClass(RequestObject<FreeClassParameter> requestObject,HttpServletRequest req);

    /**
     * 获取首页试听课程排行榜
     *  @param req
     * @return
     */
    public ResultObject<List<ListeningClassRankingDto>> listeningClassRanking(HttpServletRequest req);

    /**
     * 获取首页试听课程列表
     * @param req
     * @return
     */
    public ResultObject<List<ListeningClassListDto>> listeningClassList(HttpServletRequest req);

    /**
     * 获取首页老师排行榜
     * @param req
     * @return
     */
    public ResultObject<List<TeacherRankingDto>> teacherRanking(HttpServletRequest req);

    /**
     * 获取首页老师集合
     * @param req
     * @return
     */
    public ResultObject<List<TeacherListDto>> teacherList(HttpServletRequest req);


    /**学生端课程*/


    /**
     * 课程详情--课程包简介
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<CourseIntroDto> courseIntro(RequestObject<CourseIntroParameter> requestObject,HttpServletRequest req);

    /**
     * 课程详情--课程包体系
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<CourseChapterDto>> courseChapter(RequestObject<CourseIntroParameter> requestObject,HttpServletRequest req);

    /**
     * 课程详情--课程包评论
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<CourseEvaluationDto>> courseEvaluation(RequestObject<CourseIntroParameter> requestObject,HttpServletRequest req);

    /**
     * 课程详情--教师信息
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<TeacherInfoDto> teacherInfo(RequestObject<CourseIntroParameter> requestObject,HttpServletRequest req);

    /**
     * 课程列表
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<CourseListDto>> courseList(RequestObject<CourseListParameter >requestObject,
                                                        HttpServletRequest req);

    /**学生端--通用--名师*/

    /**名师列表*/
    /**
     * 名师列表
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<TopTeacherListDto>> topTeacherList(RequestObject<TopTeacherListParameter> requestObject,
                                                                HttpServletRequest req);

    /**名师详情--讲师简介*/
    /**
     * 名师详情--讲师简介
     * @param uid
     * @param req
     * @return
     */
    public ResultObject<List<TopTeacherInfoDto>> topTeacherInfo(@RequestParam("uid") String uid, HttpServletRequest req);

    /**
     * 名师详情--全部课程
     * @param uid
     * @param req
     * @return
     */
    public ResultObject<List<TeacherCourseDto>> teacherCourse(@RequestParam("uid") String uid, HttpServletRequest req);

    /**
     * 名师详情--评论列表
     * @param uid
     * @param req
     * @return
     */
    public ResultObject<List<TeacherEvaluationDto>> teacherEvaluation(@RequestParam("uid") String uid, HttpServletRequest req);


    /**学生端--通用--运营商*/
    /**
     * 运营商--学校介绍
     * @param req
     * @return
     */
    public ResultObject<TenantSchoolDto> tenantSchool(HttpServletRequest req);

    /**
     * 运营商--画册
     * @param req
     * @return
     */
    public ResultObject<TenantAlbumDto> tenantAlbum(HttpServletRequest req);


    public ResultObject<List<MyIndexCourseDto>> myIndexCourse(RequestObject<MyIndexCourseParameter> requestObject,
                                                              HttpServletRequest req);

    /**
     * 学生端-个人中心--首页--我的课程详情介绍
     * @param uid
     * @param req
     * @return
     */
    public ResultObject<List<IndexCourseDetailsDto>> indexCourseDetails(@RequestParam("uid")String uid,HttpServletRequest req);


    /**
     * 学生端-个人中心--首页--课程答疑
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<MyIndexCourseAnswerDto>> myIndexCourseAnswer(RequestObject<MyIndexCourseAnswerParameter> requestObject,
                                                                          HttpServletRequest req);
    /**
     * 學生個人中心消息
     * @param req
     * @return
     */
    public  ResultObject<List<MyIndexMessageDto>> myIndexMessage(HttpServletRequest req,RequestObject<MyIndexMessageParamter> paramter);

    /**
     * 刪除消息
     * @param uid
     * @return
     */
    public ResultObject<Void> deleteMessage(String uid);

    /**
     * 查詢單個消息
     * @param uid
     * @return
     */
    public ResultObject<MyIndexMessageDto>selectMessageById(String uid);

    /**
     * 学生端-个人中心--首页--兑换记录
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<MyIndexBuyRecordDto>> myIndexBuyRecord(RequestObject<MyIndexBuyRecordParameter> requestObject,
                                                                    HttpServletRequest req);

    /**
     * 學生信息
     * @param reg
     * @param uid
     * @param tid
     * @return
     */
    public  ResultObject<StudentInfoDto> studentInfo(HttpServletRequest reg,String uid,String tid);

    /**
     * 消息記錄
     * @param reg
     * @param parameter
     * @return
     */
    public ResultObject<List<MyIndexMyintegralDetailDto>> myIndexMyintegralDetail(HttpServletRequest reg,RequestObject<MyIndexMyintegralDetailParameter> parameter);

    /**
     * 近期课程
     * @param reg
     * @param uid
     * @param tid
     * @return
     */
    public  ResultObject<List<IndexFutureCoruseDto>> indexFutureCoruse(HttpServletRequest reg,String uid,String tid);

    /**
     *名师资源
     * @param reg
     * @return
     */
    public ResultObject<List<IndexTeacherDto>> indexTeacher(HttpServletRequest reg);
    /**
     *课程疑答
     * @param reg
     * @return
     */
    public ResultObject<List<IndexAnswerDto>> indexAnswer(HttpServletRequest reg);

    /**
     * 课程列表
     * @param reg
     * @param parameter
     * @return
     */
    public ResultObject<List<IndexCoruseListDto>> indexCoruseList(HttpServletRequest reg,RequestObject<IndexCoruseListParameter> parameter);
    /**
     * 名师资源列表
     * @param reg
     * @param parameter
     * @return
     */
    public ResultObject<List<IndexTeacherListDto>> indexTeacherList(HttpServletRequest reg,RequestObject<IndexTeacherListParameter> parameter);

    /**
     * 学生端-个人中心--首页--兑换记录--课程详情
     * @param uid
     * @return
     */
    public ResultObject<List<MyIndexBuyRecordCourseDetailsDto>> myIndexBuyRecordCourseDetails(String uid);

    /**
     * 学生端-个人中心--首页--兑换记录--课程回看
     * @return
     */
    public ResultObject<List<MyIndexBuyRecordCourseBackDto>> myIndexBuyRecordCourseBack(RequestObject<MyIndexBuyRecordCourseBackParameter> requestObject,HttpServletRequest req);

    /**
     * 学生端-个人中心--首页--我的收藏列表
     * @param requestObject
     * @param req
     * @return
     */
    public ResultObject<List<MyIndexMycollectDto>> myIndexMycollect(RequestObject<MyIndexMycollectParameter>requestObject,HttpServletRequest req);

    /**
     * 学生端-个人中心--首页--取消收藏列表
     * @param uid
     * @param student_id
     * @param req
     * @return
     */
    public ResultObject<Void> myIndexCancelcollect(@RequestParam("uid") String uid,@RequestParam("student_id") String student_id,HttpServletRequest req);
}


