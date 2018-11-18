package com.qht.mapper;

import org.springframework.stereotype.Repository;

import com.qht.entity.Message;
import com.qht.model.IndexMessageModel;
import com.qht.model.UidAndTenantIDParam;

import tk.mybatis.mapper.common.Mapper;

/**
 * 站内消息
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface MessageMapper extends Mapper<Message> {
	/**
	 * 教师端首页--我的消息--删除
	 * @param param
	 * @return
	 */
	Integer deleteMessage(UidAndTenantIDParam param);
	/**
	 * 教师端首页--我的消息--查看详情
	 * @param param
	 * @return
	 */
	IndexMessageModel selectIndexDelMessageDetails(UidAndTenantIDParam param);
	
}
