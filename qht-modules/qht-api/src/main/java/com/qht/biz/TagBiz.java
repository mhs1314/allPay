package com.qht.biz;

import com.qht.model.AppStudentParam;
import com.qht.model.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Tag;
import com.qht.mapper.TagMapper;

import java.util.List;

/**
 * 标签表
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class TagBiz extends BaseBiz<TagMapper,Tag> {

	@Autowired
	private TagMapper tagMapper;
	/**
	 * 查看兴趣标签
	 * @param parameter
	 * @return
	 */

	public List<TagModel> appMyStudentInterest (AppStudentParam parameter){
		return  tagMapper.appMyStudentInterest(parameter);
	}
}