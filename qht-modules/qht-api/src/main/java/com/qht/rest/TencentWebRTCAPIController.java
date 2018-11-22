package com.qht.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qht.RequestObject;
import com.qht.ResultBuilder;
import com.qht.ResultObject;
import com.qht.biz.ConfigBiz;
import com.qht.biz.TencentWebRTCBiz;
import com.qht.dto.UserSigDto;
import com.qht.dto.UserSigParameter;
import com.qht.entity.Config;

import tk.mybatis.mapper.util.StringUtil;

@RestController
@RequestMapping("webrtc")
public class TencentWebRTCAPIController {
	
	@Autowired
	ConfigBiz cfgBiz;
	@Autowired
	private TencentWebRTCBiz webRTCBiz;
	
	/**
	 * 用户签名  genUserSig
	 */
	@PostMapping("genUserSig")
	public ResultObject<UserSigDto> genUserSig(@RequestBody RequestObject<UserSigParameter> requestObject) {
		if(requestObject == null || requestObject.getData() == null) {
			return ResultBuilder.error(requestObject, "-1", "请求参数为空");
		}
		String userid = requestObject.getData().getUid();
		if(StringUtil.isEmpty(userid)) {
			return ResultBuilder.error(requestObject, "-2", "请求参数为空");
		}	
		
		Config cfg = cfgBiz.getConfig("PZ001");
		String sdkappid = cfg.getSdkappid();
		String privateKey = cfg.getPrivateKey();
		String publicKey = cfg.getPublicKey();
		if(StringUtil.isEmpty(sdkappid)) {
			return ResultBuilder.error(requestObject.getRequestId(), "-1", "sdkappid为空");
		}else if(StringUtil.isEmpty(privateKey)) {
			return ResultBuilder.error(requestObject.getRequestId(), "-2", "privateKey为空");
		}else if(StringUtil.isEmpty(publicKey)) {
			return ResultBuilder.error(requestObject.getRequestId(), "-3", "publicKey为空");
		}
		
		webRTCBiz.setSdkAppid(Integer.parseInt(sdkappid));
		webRTCBiz.setPrivateKey(privateKey);
		webRTCBiz.setPublicKey(publicKey);
		
		String userSig = webRTCBiz.genUserSig(userid, 3600);
		UserSigDto dto = new UserSigDto();
		dto.setUserSig(userSig);
		dto.setUserId(userid);
		return ResultBuilder.success(requestObject, dto);
	}
	/**
	 * 获取签名与私钥-暂时没有用上
	 * @param requestObject
	 * @return
	 
	@PostMapping("sign")
    public ResultObject<UserSigDto> sign(@RequestBody RequestObject<Void> requestObject){
		int roomid = 1234;           //音视频房间号roomid    	
        String userid = "webrtc98";  //用户名userid   
		UserSigDto data = webRTCBiz.sign(roomid,userid);	
		return ResultBuilder.success(requestObject, data);
	}
	*/
}
