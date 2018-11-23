package com.qht.mapper;

import com.qht.entity.School;

import com.qht.model.TenantSchoolModel;
import com.qht.model.UidAndTenantIDParam;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * 学校
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface SchoolMapper extends Mapper<School> {

	/**
	 * 运营商--学校介绍
	 * @return
	 */

	TenantSchoolModel selectTenantSchool(UidAndTenantIDParam param);
	
}
