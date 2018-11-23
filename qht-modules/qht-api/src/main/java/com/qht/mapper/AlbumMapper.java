package com.qht.mapper;

import com.qht.entity.Album;

import com.qht.model.TenantAlbumModel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 学校画册
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 * @Mapper
 */
@Repository
public interface AlbumMapper extends Mapper<Album> {

	/**
	 * 运营商--画册
	 * @param tenant_id
	 * @return
	 */

	List<TenantAlbumModel> selectTenantAlbum(String tenant_id);
	
}
