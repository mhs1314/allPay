package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.GradetListDto;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.PkgGrade;
import com.qht.mapper.PkgGradeMapper;

/**
 * 课程包年级
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class PkgGradeBiz extends BaseBiz<PkgGradeMapper,PkgGrade> {
	@Autowired
	private PkgGradeMapper pkgGradeMapper;
	/**
	 * 所有包年级
	 * @return
	 */
	public List<GradetListDto> gradetList(UidAndTenantID ut){
		return pkgGradeMapper.gradetList(ut);
	}
}