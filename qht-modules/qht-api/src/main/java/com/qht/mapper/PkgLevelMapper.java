package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.entity.PkgLevel;
import com.qht.model.SelectPkgLevelAllModel;
import com.qht.model.UidAndTenantIDParam;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程包班级
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface PkgLevelMapper extends Mapper<PkgLevel> {
	/**
	 * 所有班级
	 * @param param
	 * @return
	 */
	List<SelectPkgLevelAllModel> selectPkgLevelAll(UidAndTenantIDParam param);
	
}
