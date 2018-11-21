package com.qht.rest;

import com.github.wxiaoqi.security.common.rest.BaseController;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.biz.CollectBiz;
import com.qht.common.util.BeanUtil;
import com.qht.common.util.IdGenUtil;
import com.qht.dto.AppInsertCollectParameter;
import com.qht.dto.UidAndTenantID;
import com.qht.entity.Collect;
import com.qht.model.AppInsertCollectParam;
import com.qht.model.UidAndTenantIDParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("collect")
public class CollectController extends APIBaseController<CollectBiz,Collect> {
	@Autowired
	 private CollectBiz collectBiz;
	/**
	 *app 学生收藏
	 * @param requestObject
	 * @return
	 */
	@PostMapping("student/app/likeThisClass")
	@ResponseBody
	public ResultObject<Void> appInsertCollect(@RequestBody RequestObject<AppInsertCollectParameter> requestObject){
		if(requestObject.getData()==null) {
			 ResultObject<Void> result=new ResultObject<>();
			 result.setCode("1");
			 result.setMsg("没有参数添加失败");
			 return result;
		}
		AppInsertCollectParam param=new AppInsertCollectParam();
		BeanUtil.copyFields(param, requestObject.getData());
		param.setUid(IdGenUtil.getUid("IN"));
		param.setIs_collect("1");
		Integer i=collectBiz.appInsertCollect(param);
		if(i==null||i<=0) {
			 ResultObject<Void> result=new ResultObject<>();
			 result.setCode("1");
			 result.setMsg("添加失败");
			 return result;
		}
		ResultObject<Void> result=new ResultObject<>();
		 result.setCode("0");
		 result.setMsg("收藏成功");
		 return result;
	}
	/**
	 * 取消收藏
	 * @return
	 */
	@PostMapping("student/app/CancelLikeForClass")
	@ResponseBody
	public ResultObject<Void> appUpdateCOllect(@RequestBody RequestObject<UidAndTenantID> requestObject){
		if(requestObject.getData()==null) {
			 ResultObject<Void> result=new ResultObject<>();
			 result.setCode("1");
			 result.setMsg("没有参数取消失败");
			 return result;
		}
		UidAndTenantIDParam param=new UidAndTenantIDParam();
		BeanUtil.copyFields(param, requestObject.getData());
		param.setUid(IdGenUtil.getUid("IN"));
		Integer i=collectBiz.appUpdateCOllect(param);
		if(i==null||i<=0) {
			 ResultObject<Void> result=new ResultObject<>();
			 result.setCode("1");
			 result.setMsg("取消失败");
			 return result;
		}
		ResultObject<Void> result=new ResultObject<>();
		 result.setCode("0");
		 result.setMsg("取消成功");
		 return result;
	}
}