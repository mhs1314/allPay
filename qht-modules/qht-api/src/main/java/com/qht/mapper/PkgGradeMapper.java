package com.qht.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qht.dto.GradetListDto;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.PkgGrade;

import tk.mybatis.mapper.common.Mapper;

/**
 * 课程包年级
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface PkgGradeMapper extends Mapper<PkgGrade> {
	/**
	 * 所有包年级
	 * @return
	 */
	List<GradetListDto> gradetList(UidAndTenantID ut);
	
}
