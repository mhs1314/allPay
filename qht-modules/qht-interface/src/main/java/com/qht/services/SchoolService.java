package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.TenantSchoolDto;
import com.qht.dto.UidAndTenantID;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 学校
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface SchoolService {

	/**学生端--通用--运营商*/
	/**
	 * 运营商--学校介绍
	 * @return
	 */
	public ResultObject<TenantSchoolDto> tenantSchool(@RequestBody RequestObject<UidAndTenantID> uid);

}