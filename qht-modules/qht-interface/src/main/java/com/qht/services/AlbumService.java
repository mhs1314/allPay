package com.qht.services;

import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.dto.TenantAlbumDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 学校画册
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-05 18:55:41
 */
public interface AlbumService {

	/**
	 * 运营商--画册
	 * @return
	 */
	public ResultObject<List<TenantAlbumDto>> tenantAlbum(@RequestBody RequestObject<Void> uid);

}
