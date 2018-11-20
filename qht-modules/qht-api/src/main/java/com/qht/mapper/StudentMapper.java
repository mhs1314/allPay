package com.qht.mapper;

import com.qht.dto.CourseChapterDto;
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
     * 课程详情--课程包评论
     * @return
     */
    List<CourseEvaluationModel> selectCourseEvaluation(CourseEvaluationParam data);
    List<CourseEvaluationModel> selectCourseEvaluationGood(CourseEvaluationParam data);
    List<CourseEvaluationModel> selectCourseEvaluationBad(CourseEvaluationParam data);
    List<CourseEvaluationModel> selectCourseEvaluationMid(CourseEvaluationParam data);



    /**
     * 名师详情--评论列表
     * @param uid
     * @param tenant_id
     * @return
     */

    List<TeacherEvaluationModel> selectTeacherEvaluation(@Param("uid")String uid, @Param("tenant_id") String tenant_id);








    /**
     * 查詢學生信息
     * @param uid
     * @param tenant_id
     * @return
     */

    StudentInfoModel studentInfo(@Param("uid")String uid,@Param("tenant_id")String tenant_id);

    /**
     * 学生端-个人中心--首页--我的收藏列表--取消收藏
     */
    Integer updateMyIndexCancelcollect(MyIndexCanceCollectParam param);


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
     * 学生余额
     */
    Integer selectbalance(String uid);

    /**
     * 修改余额
     */
    Integer updateBalance(UidAndTenantIDParam param);

}
