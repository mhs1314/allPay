package com.qht.mapper;

import com.qht.entity.Answer;

import com.qht.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 课程答疑
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface AnswerMapper extends Mapper<Answer> {

	/**
	 * 学生端-个人中心--首页--课程答疑
	 * @param data
	 * @return
	 */

	List<MyIndexCourseAnswerModel> selectMyIndexCourseAnswer(MyIndexCourseAnswerParam data);

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
	 * 我的课程答疑--答疑详情-追问回答
	 * @param data
	 * @return
	 */
	Integer indsertAppendAskAnswer(IndexAnswerDetailsAppendAnswerParam data);

	/**
	 * 教师端首页--课程答疑列表
	 * @param param
	 * @return
	 */
	List<IndexCourseAnswerModel> selectIndexCourseAnswer(IndexCourseAnswerParam param);


	
}
