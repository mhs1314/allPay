package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.OpenRange;
import com.qht.mapper.OpenRangeMapper;
import com.qht.model.SelectOpenRangeAllModel;
import com.qht.model.UidAndTenantIDParam;

/**
 * 播放范围
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class OpenRangeBiz extends BaseBiz<OpenRangeMapper,OpenRange> {
	@Autowired
	private OpenRangeMapper openRangeMapper;
	/**
	 *课程包范围
	 * @param param
	 * @return
	 */
	public List<SelectOpenRangeAllModel> selectOpenRangeAll(UidAndTenantIDParam param){
		return openRangeMapper.selectOpenRangeAll(param);
	}
}