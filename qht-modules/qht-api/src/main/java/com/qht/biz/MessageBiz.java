package com.qht.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Message;
import com.qht.mapper.MessageMapper;
import com.qht.model.IndexMessageModel;
import com.qht.model.UidAndTenantIDParam;

/**
 * 站内消息
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class MessageBiz extends BaseBiz<MessageMapper,Message> {
	@Autowired
	private MessageMapper messageMapper;
	/**
	 * 教师端首页--我的消息--删除
	 * @param param
	 * @return
	 */
	public Integer deleteMessage(UidAndTenantIDParam param) {
		
		return messageMapper.deleteMessage(param);
	}
	/**
	 * 教师端首页--我的消息--查看详情
	 * @param param
	 * @return
	 */
	public IndexMessageModel selectIndexDelMessageDetails(UidAndTenantIDParam param) {
		
		return messageMapper.selectIndexDelMessageDetails(param);
	}
}