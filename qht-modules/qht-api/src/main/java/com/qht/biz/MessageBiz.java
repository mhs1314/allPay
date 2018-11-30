package com.qht.biz;

import com.qht.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Message;
import com.qht.mapper.MessageMapper;

import java.util.List;

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
	public Integer deleteMessaget(UidAndTenantIDParam param) {
		
		return messageMapper.deleteMessaget(param);
	}
	/**
	 * 教师端首页--我的消息--查看详情
	 * @param param
	 * @return
	 */
	public IndexMessageModel selectIndexDelMessageDetails(UidAndTenantIDParam param) {
		
		return messageMapper.selectIndexDelMessageDetails(param);
	}

	/**
	 * 消息
	 * @param paramter
	 * @return
	 */
	public List<MyIndexMessageModel> selectMyIndexMessage(MyIndexMessageParam paramter) {
		return messageMapper.selectMyIndexMessage(paramter.getUid(), paramter.getTenant_id(), paramter.getIsread());
	}

	/**
	 * 刪除消息
	 *
	 * @param id
	 * @return
	 */
	public Integer deleteMessages(String id) {
		return messageMapper.deleteMessages(id);
	}

	/**
	 * 查詢信息
	 * @return
	 */

	public MyIndexMessageModel selectMessageById(UidAndTenantIDParam param) {
		return messageMapper.selectMessageById(param);
	}
	/**
	 * 教师端首页--我的消息
	 * @param param
	 * @return
	 */
	public List<IndexMessageModel> selectIndexMessage(IndexMessageParam param) {

		return messageMapper.selectIndexMessage(param);
	}
}