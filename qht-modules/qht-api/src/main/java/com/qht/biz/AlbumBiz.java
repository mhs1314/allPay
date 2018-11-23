package com.qht.biz;

import com.qht.model.TenantAlbumModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.wxiaoqi.security.common.biz.BaseBiz;
import com.qht.entity.Album;
import com.qht.mapper.AlbumMapper;

import java.util.List;

/**
 * 学校画册
 *
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
@Service
public class AlbumBiz extends BaseBiz<AlbumMapper,Album> {
	@Autowired
	private AlbumMapper albumMapper;
	/**
	 * 运营商--画册
	 * @param tenant_id
	 * @return
	 */

	public List<TenantAlbumModel> selectTenantAlbum(String tenant_id) {
		return albumMapper.selectTenantAlbum(tenant_id);
	}
}