package com.qht.mapper;

import com.qht.dto.MyCollectlistDto;
import com.qht.entity.Collect;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 收藏表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface CollectMapper extends Mapper<Collect> {
    /**
     * 我的收藏列表
     * @param uid
     * @param tid
     * @return
     */
    List<MyCollectlistDto> myCollectlist(@Param("uid")String uid,@Param("tid")String tid);
	
}
