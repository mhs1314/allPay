package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.entity.PkgEdition;
import com.qht.model.SelectPkgEditionAllModel;
import com.qht.model.UidAndTenantIDParam;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程包版本
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface PkgEditionMapper extends Mapper<PkgEdition> {
	/**
	 * 所有课程包版本
	 * @param param
	 * @return
	 */
	List<SelectPkgEditionAllModel> selectPkgEditionAll(UidAndTenantIDParam param);
	
}
