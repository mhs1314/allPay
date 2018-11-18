package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.PkgEdition;
import com.qht.mapper.PkgEditionMapper;
import com.qht.model.SelectPkgEditionAllModel;
import com.qht.model.UidAndTenantIDParam;

/**
 * 课程包版本
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class PkgEditionBiz extends BaseBiz<PkgEditionMapper,PkgEdition> {
	@Autowired
	private PkgEditionMapper pkgEditionMapper;
	/**
	 * 所有课程包版本
	 * @param param
	 * @return
	 */
	public List<SelectPkgEditionAllModel> selectPkgEditionAll(UidAndTenantIDParam param){
		return pkgEditionMapper.selectPkgEditionAll(param);
	}
	
}