package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Period;
import com.qht.mapper.PeriodMapper;
import com.qht.model.IndexMyCourseTableModel;
import com.qht.model.IndexMyCourseTableParam;

/**
 * 课时
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class PeriodBiz extends BaseBiz<PeriodMapper,Period> {
	@Autowired
	private PeriodMapper periodMapper;
	/**
	 * 课时
	 * 
	 * @author yangtonggan
	 * @email 2466607841@qq.com
	 * @date 2018-11-05 18:55:41
	 * @Mapper
	 */
	public List<IndexMyCourseTableModel>indexMycourseTable(IndexMyCourseTableParam param){
		return periodMapper.indexMycourseTable(param);
	}
}