package com.qht.mapper;

import com.qht.model.IndexMessageParam;
import com.qht.model.MyIndexMessageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.qht.entity.Message;
import com.qht.model.IndexMessageModel;
import com.qht.model.UidAndTenantIDParam;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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
	Integer deleteMessaget(UidAndTenantIDParam param);
	/**
	 * 教师端首页--我的消息--查看详情
	 * @param param
	 * @return
	 */
	IndexMessageModel selectIndexDelMessageDetails(UidAndTenantIDParam param);

	/**
	 * 消息
	 * @param uid
	 * @param tenant_id
	 * @param isread
	 * @return
	 */

	List<MyIndexMessageModel> selectMyIndexMessage(@Param("uid")String uid, @Param("tenant_id")String tenant_id, @Param("isread")String isread);

	/**
	 * 刪除消息
	 * @param uid
	 * @return
	 */
	Integer deleteMessages(String uid);

	/**
	 * 查詢消息
	 * @return
	 */

	MyIndexMessageModel selectMessageById(UidAndTenantIDParam param);

	/**
	 * 教师端首页--我的消息
	 * @param param
	 * @return
	 */
	List<IndexMessageModel> selectIndexMessage(IndexMessageParam param);
	
}
