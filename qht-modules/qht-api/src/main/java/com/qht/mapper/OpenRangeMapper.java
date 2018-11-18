package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.entity.OpenRange;
import com.qht.model.SelectOpenRangeAllModel;
import com.qht.model.UidAndTenantIDParam;

import tk.mybatis.mapper.common.Mapper;

/**
 * 播放范围
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface OpenRangeMapper extends Mapper<OpenRange> {
	/**
	 *课程包范围
	 * @param param
	 * @return
	 */
	List<SelectOpenRangeAllModel> selectOpenRangeAll(UidAndTenantIDParam param);
	
}
