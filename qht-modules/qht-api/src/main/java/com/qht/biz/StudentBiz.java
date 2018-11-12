package com.qht.biz;

import com.qht.dto.*;
import org.apache.ibatis.annotations.Param;
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
     * @param account
     * @param password
     * @return
     */
    public StudentDto studentLogin(String account, String password){
        return studentMapper.studentLogin(account,password);
    }

    /**
     * 首页查询banner
     * @param tenantId
     * @return
     */
    public List<BannerDto> selectBanner(String tenantId) {
        return studentMapper.selectBanner(tenantId);
    }

    /**
     * 首页查询直播课程
     * @param tenantId
     * @return
     */
    public List<LiveClassDto> selectLiveClass(String tenantId) {
        return studentMapper.selectLiveClass(tenantId);
    }

    /**
     * 查询首页的免费课程
     * @param pkg_subject_id
     * @param pkg_grade_id
     * @param tenantId
     * @return
     */
    public List<FreeClassDto> selectFreeClass(String pkg_subject_id, String pkg_grade_id, String tenantId) {
        return studentMapper.selectFreeClass(pkg_subject_id,pkg_grade_id,tenantId);
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
     * @param tenantId
     * @return
     */
    public List<CourseListDto> selectCourseList(CourseListParameter data, String tenantId) {
        return studentMapper.selectCourseList(data,tenantId);
    }

    /**
     * 名师列表
     * @param data
     * @param tenantId
     * @return
     */
    public List<TopTeacherListDto> selectTopTeacherList(TopTeacherListParameter data, String tenantId) {
        return studentMapper.selectTopTeacherList(data,tenantId);
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
}