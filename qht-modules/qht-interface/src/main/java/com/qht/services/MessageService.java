package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.MyIndexMessageDto;
import com.qht.dto.MyIndexMessageParamter;
import com.qht.dto.UidAndTenantID;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 站内消息
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface MessageService {

	/**
	 * 刪除消息
	 * @return
	 */
	public ResultObject<Void> deleteMessage(@RequestBody RequestObject<UidAndTenantID> requestObject);

	/**
	 * 學生個人中心消息
	 * @return
	 */
	public ResultObject<List<MyIndexMessageDto>> myIndexMessage(@RequestBody RequestObject<MyIndexMessageParamter> paramter);

	/**
	 * 查詢單個消息
	 * @param requestObject
	 * @return
	 */
	public ResultObject<MyIndexMessageDto>selectMessageById(@RequestBody RequestObject<UidAndTenantID> requestObject);
}
