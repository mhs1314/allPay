package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.PkgLevel;
import com.qht.mapper.PkgLevelMapper;
import com.qht.model.SelectPkgLevelAllModel;
import com.qht.model.UidAndTenantIDParam;

/**
 * 课程包班级
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class PkgLevelBiz extends BaseBiz<PkgLevelMapper,PkgLevel> {
	@Autowired
	private PkgLevelMapper pkgLevelMapper;
	/**
	 * 所有班级
	 * @param param
	 * @return
	 */
	public List<SelectPkgLevelAllModel> selectPkgLevelAll(UidAndTenantIDParam param){
		return pkgLevelMapper.selectPkgLevelAll(param);
				
	}

	/**
	 * 查询积分
	 */
	public Integer selectValue(String uid) {
	return 	pkgLevelMapper.selectValue(uid);
	}
}