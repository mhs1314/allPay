package com.qht.biz;

import com.qht.dto.MyCollectlistDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Collect;
import com.qht.mapper.CollectMapper;
import com.qht.model.MyIndexCourseCelcollectParam;

import java.util.List;

/**
 * 收藏表
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class CollectBiz extends BaseBiz<CollectMapper,Collect> {
    @Autowired
    private CollectMapper collectMapper;
    /**
     * 我的收藏列表
     * @param uid
     * @param tid
     * @return
     */
    public List<MyCollectlistDto> myCollectlist(String uid, String tid){
        return collectMapper.myCollectlist(uid,tid);

    }
    /**
     * 学生端-个人中心--首页--课程详情--收藏
     * @param param
     * @return
     */
	public Integer insertMyIndexCourseCelcollect(MyIndexCourseCelcollectParam param) {
		
		return collectMapper.insertMyIndexCourseCelcollect(param);
	}
}