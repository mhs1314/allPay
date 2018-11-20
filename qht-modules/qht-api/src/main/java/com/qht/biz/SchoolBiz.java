package com.qht.biz;

import com.qht.model.TenantSchoolModel;
import com.qht.model.UidAndTenantIDParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.School;
import com.qht.mapper.SchoolMapper;

/**
 * 学校
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class SchoolBiz extends BaseBiz<SchoolMapper,School> {
	@Autowired
	private SchoolMapper schoolMapper;
	/**
	 * 运营商--学校介绍
	 * @return
	 */


	public TenantSchoolModel selectTenantSchool(UidAndTenantIDParam param) {
		return schoolMapper.selectTenantSchool(param);
	}
}