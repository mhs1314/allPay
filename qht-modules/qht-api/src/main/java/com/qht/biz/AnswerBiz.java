package com.qht.biz;

import com.qht.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Answer;
import com.qht.mapper.AnswerMapper;

import java.util.List;

/**
 * 课程答疑
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class AnswerBiz extends BaseBiz<AnswerMapper,Answer> {
	@Autowired
	private AnswerMapper answerMapper;

	/**
	 *学生端-个人中心--首页--课程答疑
	 * @param data
	 * @return
	 */

	public List<MyIndexCourseAnswerModel> selectMyIndexCourseAnswer(MyIndexCourseAnswerParam data) {
		return answerMapper.selectMyIndexCourseAnswer(data);
	}

	/**
	 * app我的课程答疑
	 * @param uid
	 * @param tenant_id
	 * @return
	 */
	public List<IndexMyAnswerModel> selectIndexMyAnswer(String uid, String tenant_id) {
		return answerMapper.selectIndexMyAnswer(uid,tenant_id);
	}
	/**
	 * app我的课程答疑--答疑详情
     * @param uid
     * @param tenant_id
     * @return
	 */
	public IndexAnswerDetailsModel selectIndexAnswerDetails(String uid, String tenant_id) {
		return answerMapper.selectIndexAnswerDetails(uid,tenant_id);
	}
	/**
	 * 我的课程答疑--答疑详情-追问回答
	 * @param data
	 * @return
	 */

	public Integer insertAppendAskAnswer(IndexAnswerDetailsAppendAnswerParam data) {
		return answerMapper.indsertAppendAskAnswer(data);
	}

	/**
	 * 教师端首页--课程答疑列表
	 * @param param
	 * @return
	 */
	public List<IndexCourseAnswerModel> selectIndexCourseAnswer(IndexCourseAnswerParam param) {
		return answerMapper.selectIndexCourseAnswer(param);
	}
}