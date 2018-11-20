package com.qht.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.AppMyStudentGuardianDto;
import com.qht.dto.AppMyStudentInfoDto;
import com.qht.dto.AppStudentParameter;
import com.qht.dto.AppTeacherCourseDto;
import com.qht.dto.AppTeacherEvaluationDto;
import com.qht.dto.BannerDto;
import com.qht.dto.CourseChapterDto;
import com.qht.dto.CourseEvaluationDto;
import com.qht.dto.CourseEvaluationParameter;
import com.qht.dto.CourseIntroDto;
import com.qht.dto.CourseIntroParameter;
import com.qht.dto.CourseListDto;
import com.qht.dto.CourseListParameter;
import com.qht.dto.FreeClassDto;
import com.qht.dto.FreeClassParameter;
import com.qht.dto.IndexAnswerDetailsAppendAnswerParameter;
import com.qht.dto.IndexAnswerDetailsDto;
import com.qht.dto.IndexAnswerDetailsExceptionalParameter;
import com.qht.dto.IndexAnswerDto;
import com.qht.dto.IndexCoruseListDto;
import com.qht.dto.IndexCoruseListParameter;
import com.qht.dto.IndexCourseDetailsDto;
import com.qht.dto.IndexFutureCoruseDto;
import com.qht.dto.IndexMyAnswerDto;
import com.qht.dto.IndexMyCourseTableDto;
import com.qht.dto.IndexMyCourseTableParameter;
import com.qht.dto.IndexTeacherDto;
import com.qht.dto.IndexTeacherListDto;
import com.qht.dto.IndexTeacherListParameter;
import com.qht.dto.ListeningClassListDto;
import com.qht.dto.ListeningClassRankingDto;
import com.qht.dto.LiveClassDto;
import com.qht.dto.LoginInfoDto;
import com.qht.dto.MyCollectlistDto;
import com.qht.dto.MyIndexBuyRecordCourseBackDto;
import com.qht.dto.MyIndexBuyRecordCourseBackParameter;
import com.qht.dto.MyIndexBuyRecordCourseDetailsDto;
import com.qht.dto.MyIndexBuyRecordDto;
import com.qht.dto.MyIndexBuyRecordParameter;
import com.qht.dto.MyIndexCanceCollectParameter;
import com.qht.dto.MyIndexCourseAnswerDto;
import com.qht.dto.MyIndexCourseAnswerParameter;
import com.qht.dto.MyIndexCourseCelcollectParameter;
import com.qht.dto.MyIndexCourseDetailsDto;
import com.qht.dto.MyIndexCourseDto;
import com.qht.dto.MyIndexCourseParameter;
import com.qht.dto.MyIndexMessageDto;
import com.qht.dto.MyIndexMessageParamter;
import com.qht.dto.MyIndexMycollectDto;
import com.qht.dto.MyIndexMycollectParameter;
import com.qht.dto.MyIndexMyintegralDetailDto;
import com.qht.dto.MyIndexMyintegralDetailParameter;
import com.qht.dto.SelectPkgByStuIdDto;
import com.qht.dto.StudentDto;
import com.qht.dto.StudentInfoDto;
import com.qht.dto.TeacherCourseDto;
import com.qht.dto.TeacherDetailsDto;
import com.qht.dto.TeacherEvaluationDto;
import com.qht.dto.TeacherInfoDto;
import com.qht.dto.TeacherListDto;
import com.qht.dto.TeacherListParameter;
import com.qht.dto.TeacherRankingDto;
import com.qht.dto.TenantAlbumDto;
import com.qht.dto.TenantSchoolDto;
import com.qht.dto.TopTeacherInfoDto;
import com.qht.dto.TopTeacherListDto;
import com.qht.dto.TopTeacherListParameter;
import com.qht.dto.UidAndTenantID;


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
    public ResultObject<StudentDto> login(@RequestBody RequestObject<LoginInfoDto> requestObject);

    /**
     * 获取首页广告信息
     * @return
     */
    public ResultObject<List<BannerDto>> banner(@RequestBody RequestObject<UidAndTenantID> requestObject);
    /**
     * 获取首页广告信息--App
     * @return
     */
    public ResultObject<List<BannerDto>> indexBanner(@RequestBody RequestObject<UidAndTenantID> requestObject);

    /**
     * 获取首页老师排行榜
     * @return
     */
    public ResultObject<List<TeacherRankingDto>> teacherRanking(@RequestBody RequestObject<UidAndTenantID> requestObject);

    /**
     * 获取首页老师集合
     * @return
     */
    public ResultObject<List<TeacherListDto>> teacherList(@RequestBody RequestObject<TeacherListParameter> requestObject);


    /**学生端课程*/

    /**
     * 课程详情--课程包评论
     * @param requestObject
     * @return
     */
    public ResultObject<List<CourseEvaluationDto>> courseEvaluation(@RequestBody RequestObject<CourseEvaluationParameter> requestObject);

    /**
     * 课程详情--教师信息
     * @param requestObject
     * @return
     */
    public ResultObject<TeacherInfoDto> teacherInfo(@RequestBody RequestObject<CourseIntroParameter> requestObject);



    /**学生端--通用--名师*/

    /**名师列表*/
    /**
     * 名师列表
     * @param requestObject
     * @return
     */
    public ResultObject<List<TopTeacherListDto>> topTeacherList(@RequestBody RequestObject<TopTeacherListParameter> requestObject);

    /**名师详情--讲师简介*/
    /**
     * 名师详情--讲师简介
     * @param uid
     * @return
     */
    public ResultObject<TopTeacherInfoDto> topTeacherInfo(@RequestBody RequestObject<UidAndTenantID> uid);



    /**
     * 名师详情--评论列表
     * @param uid
     * @return
     */
    public ResultObject<List<TeacherEvaluationDto>> teacherEvaluation(@RequestBody RequestObject<UidAndTenantID> uid);

    /**
     * 學生信息
     * @return
     */
    public  ResultObject<StudentInfoDto> studentInfo(@RequestBody RequestObject<UidAndTenantID> requestObject);





    /**
     *名师资源
     * @return
     */
    public ResultObject<List<IndexTeacherDto>> indexTeacher(@RequestBody RequestObject<UidAndTenantID> req);

    /**
     * 名师资源列表
     * @param parameter
     * @return
     */
    public ResultObject<List<IndexTeacherListDto>> indexTeacherList(@RequestBody RequestObject<IndexTeacherListParameter> parameter);







    /**
     * 学生端-个人中心--首页--取消收藏列表
     * @return
     */
    public ResultObject<Void> myIndexCancelcollect(@RequestBody RequestObject<MyIndexCanceCollectParameter> requestObject);

    /**
     * 名师详情-基本信息
     * @return
     */
    public ResultObject<TeacherDetailsDto> teacherDetails(@RequestBody RequestObject<UidAndTenantID> requestObject);

    /**
     * 名师详情-所有课程
     * @return
     */
    public ResultObject<List<AppTeacherCourseDto>> appTeacherCourse(@RequestBody RequestObject<UidAndTenantID> requestObject);

    /**
     * app我的答疑打赏
     * @return
     */
    public ResultObject<Void> indexAnswerDetailsExceptional(@RequestBody RequestObject<IndexAnswerDetailsExceptionalParameter> requestObject);
    /**
     * 名师详情-所有评论
     * @return
     */
    public ResultObject<List<AppTeacherEvaluationDto>> teacherEvaluation1(@RequestBody RequestObject<TeacherEvaluationDto> requestObject);

    /**
     * 我的收藏
     * @return
     */
    public ResultObject<List<MyCollectlistDto>> myCollectlist(@RequestBody RequestObject<UidAndTenantID> requestObject);

    /***
     * 个人中心学生信息
     * @return
     */
    public ResultObject<AppMyStudentInfoDto> appMyStudentInfo(@RequestBody RequestObject<UidAndTenantID> requestObject);

    /**
     * app修改学生头像
     * @param resultObject
     * @return
     */
     public ResultObject<Void> myStudentInfoEditHead(@RequestBody RequestObject<AppStudentParameter> resultObject);

    /**
     * app修改学生昵称
     * @param resultObject
     * @return
     */
    public ResultObject<Void> myStudentInfoEditNickname(@RequestBody RequestObject<AppStudentParameter> resultObject);

    /**
     * app修改学生密码
     * @param resultObject
     * @return
     */
    public ResultObject<Void> myStudentInfoEditPs(@RequestBody RequestObject<AppStudentParameter> resultObject);

    /**
     * 查看监护人信息
     * @param resultObject
     * @return
     */
    public ResultObject<List<AppMyStudentGuardianDto>>myStudentGuardian(@RequestBody RequestObject<AppStudentParameter> resultObject);

//    /**
//     * 查看学生兴趣标签
//     * @param resultObject
//     * @return
//     */
//    public ResultObject<List<TagDto>> myStudentInterest(@RequestBody ResultObject<AppStudentParameter> resultObject);
    
    public ResultObject<List<IndexMyCourseTableDto>> indexMycourseTable(@RequestBody RequestObject<IndexMyCourseTableParameter> resultObject);
    
    /**
     * 学生端-个人中心--首页--课程详情--收藏
     * @param requestObject
     * @return
     */
    public ResultObject<Void> myIndexCourseCelcollect(@RequestBody RequestObject<MyIndexCourseCelcollectParameter> requestObject);


    /**
     *学生 个人中心课程列表
     */
    public ResultObject<List<SelectPkgByStuIdDto>> selectPkgByStuId(@RequestBody RequestObject<UidAndTenantID> requestObject);

    /**
     * 连PC通用课程包简介
     */
    public ResultObject<CourseIntroDto> appCourseIntro(@RequestBody RequestObject<CourseIntroParameter> requestObject);
}

