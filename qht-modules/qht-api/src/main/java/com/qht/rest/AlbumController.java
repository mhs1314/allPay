
package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.AlbumBiz;
import com.qht.common.util.BeanUtil;
import com.qht.dto.TenantAlbumDto;
import com.qht.entity.Album;

import com.qht.model.TenantAlbumModel;
import com.qht.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AlbumController extends APIBaseController<AlbumBiz,Album> implements AlbumService {
	@Autowired
	private AlbumBiz albumBiz;

	@Override
//	@PostMapping("/student/tenantAlbum")
	@ResponseBody
	public ResultObject<List<TenantAlbumDto>> tenantAlbum(@RequestBody RequestObject<Void> requestObject) {

		List<TenantAlbumModel> tenantAlbumDto=albumBiz.selectTenantAlbum(getTenantId());
		List<TenantAlbumDto> list = BeanUtil.copyList(TenantAlbumDto.class, tenantAlbumDto);
		ResultObject<List<TenantAlbumDto>> resultObject=new ResultObject<>();
		resultObject.setCode("0");
		resultObject.setMsg("成功");
		resultObject.setData(list);
		return resultObject;
	}
}
