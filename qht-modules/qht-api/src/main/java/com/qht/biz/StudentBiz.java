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
     * 名师详情--评论列表
     * @param uid
     * @param tenant_id
     * @return
     */

    public List<TeacherEvaluationModel> selectTeacherEvaluation(String uid, String tenant_id) {
        return studentMapper.selectTeacherEvaluation(uid,tenant_id);
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
     * 学生端-个人中心--首页--我的收藏列表--取消收藏
     */
    public Integer updateMyIndexCancelcollect(MyIndexCanceCollectParam param) {

        Integer num=studentMapper.updateMyIndexCancelcollect(param);
        return num;
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
    * 学生余额
    */
   public Integer selectbalance(String uid) {
	   return  studentMapper.selectbalance(uid);
   }
   /**
    * 修改余额
    */
  public Integer updateBalance(UidAndTenantIDParam param) {
	  return  studentMapper.updateBalance(param);
  }

}

