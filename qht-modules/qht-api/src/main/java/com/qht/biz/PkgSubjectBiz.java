package com.qht.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.dto.PkgSubjectListDto;
import com.qht.entity.PkgSubject;
import com.qht.mapper.PkgSubjectMapper;
import com.qht.mapper.StudentMapper;

/**
 * 课程包科目
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class PkgSubjectBiz extends BaseBiz<PkgSubjectMapper,PkgSubject> {
	 @Autowired
	  private PkgSubjectMapper pkgSubjectMapper;
	 /**
		 * 查看所有科目
		 * @return
		 */
		public List<PkgSubjectListDto> subjectList(){
			return pkgSubjectMapper.subjectList();
		}
}