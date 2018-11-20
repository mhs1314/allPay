package com.qht.biz;

import com.qht.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.BuyRecord;
import com.qht.mapper.BuyRecordMapper;

import java.util.List;

/**
 * 课程包购买记录
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class BuyRecordBiz extends BaseBiz<BuyRecordMapper,BuyRecord> {
	@Autowired
	private BuyRecordMapper buyRecordMapper;
	/**
	 * 学生端-个人中心--首页--我的课程列表
	 * @param data
	 * @return
	 */

	public List<MyIndexCourseModel> selectMyIndexCourse(MyIndexCourseParam data) {
		return buyRecordMapper.selectMyIndexCourse(data);
	}

	/**
	 * 学生端-个人中心--首页--兑换记录
	 * @param data
	 * @return
	 */
	public List<MyIndexBuyRecordModel> selectMyIndexBuyRecourd(MyIndexBuyRecordParam data) {
		return buyRecordMapper.selectMyIndexBuyRecord(data);
	}

	/**
	 * 消費明細
	 * @param parameter
	 * @return
	 */
	public List<MyIndexMyintegralDetailModel> myIndexMyintegralDetail(MyIndexMyintegralDetailParam parameter){
		return  buyRecordMapper.myIndexMyintegralDetail(parameter);
	}
}