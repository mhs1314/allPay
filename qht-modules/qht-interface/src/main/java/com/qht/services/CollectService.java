package com.qht.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.AppInsertCollectParameter;
import com.qht.dto.IndexAnswerDetailsAppendAnswerParameter;
import com.qht.dto.UidAndTenantID;

/**
 * 收藏表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface CollectService {
	/**
	 *app 学生收藏
	 * @param requestObject
	 * @return
	 */
	public ResultObject<Void> appInsertCollect(@RequestBody RequestObject<AppInsertCollectParameter> requestObject);
	/**
	 * 取消收藏
	 * @return
	 */
	public ResultObject<Void> appUpdateCOllect(@RequestBody RequestObject<UidAndTenantID> requestObject);

}
