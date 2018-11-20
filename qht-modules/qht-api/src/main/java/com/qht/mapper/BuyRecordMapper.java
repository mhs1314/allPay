package com.qht.mapper;

import com.qht.entity.BuyRecord;

import com.qht.model.*;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 课程包购买记录
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface BuyRecordMapper extends Mapper<BuyRecord> {
	/**
	 * 学生端-个人中心--首页--我的课程列表
	 * @param data
	 * @return
	 */

	List<MyIndexCourseModel> selectMyIndexCourse(MyIndexCourseParam data);

	/**
	 * 学生端-个人中心--首页--兑换记录
	 * @param data
	 * @return
	 */

	List<MyIndexBuyRecordModel> selectMyIndexBuyRecord(MyIndexBuyRecordParam data);

	/**
	 * 消费记录
	 * @param parameter
	 * @return
	 */

	List<MyIndexMyintegralDetailModel> myIndexMyintegralDetail(MyIndexMyintegralDetailParam parameter);
	/**
	 * 添加消费记录
	 * @param param
	 * @return
	 */
	Integer insertBuyRecord(InsertBuyrecordParam param );
}
