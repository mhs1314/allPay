package com.qht.biz;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.qht.common.util.HttpUtil;
import com.qht.dto.GroupResponseBodyDto;

/**
 * 构造地址
 * @author 草原狼
 * @date Nov 20, 2018 1:46:46 AM
 */
@Service
public class TencentCloud {
	@Autowired
	private TencentWebRTCBiz webRTCBiz = new TencentWebRTCBiz();
	// = new TencentWebRTCBiz();
	
	String baseUrl = "https://console.tim.qq.com";
	String ver = "v4";
	String servicename = "group_open_http_svc";
	String command = "create_group";
	int sdkappid = 1400154853;
	String identifier = "administrator";
	String usersig = "";
	String random = "";
	String contenttype = "json";
	
	public String toUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl).append("/");
		sb.append(ver).append("/");
		sb.append(servicename).append("/");
		sb.append(command).append("?");
		sb.append("usersig="+getUsersig(identifier)).append("&");		
		sb.append("identifier="+identifier).append("&");
		sb.append("sdkappid="+sdkappid).append("&");
		sb.append("random="+random()).append("&");
		sb.append("contenttype="+contenttype);
		return sb.toString();
	}
	
	private String getUsersig(String userid) {	
		webRTCBiz.setSdkAppid(sdkappid);
		webRTCBiz.setPrivateKey(webRTCBiz.privateKey());
		webRTCBiz.setPublicKey(webRTCBiz.publicKeyFile());		
		return webRTCBiz.genUserSig(userid, 3600);
	}
	private String random() {
		Random rand = new Random();
		StringBuffer sb=new StringBuffer();
		for (int i=1;i<=32;i++){
		    int randNum = rand.nextInt(9)+1;
		    String num=randNum+"";
		    sb=sb.append(num);
		}		
		return String.valueOf(sb);
	}
	public String createGroup(String teacherId) {
		RequestBody param = new RequestBody();
		param.setOwner_Account(teacherId);
		return HttpUtil.post(toUrl(), param.toJson());
	}
	
	class ResponseBody{
		private String ActionStatus;
		private String ErrorCode;
		private String GroupId;
		public String getActionStatus() {
			return ActionStatus;
		}
		public void setActionStatus(String actionStatus) {
			ActionStatus = actionStatus;
		}
		public String getErrorCode() {
			return ErrorCode;
		}
		public void setErrorCode(String errorCode) {
			ErrorCode = errorCode;
		}
		public String getGroupId() {
			return GroupId;
		}
		public void setGroupId(String groupId) {
			GroupId = groupId;
		}
		
	}
	class RequestBody{
		
		String Owner_Account = "Web_trtc_01";
		String Type = "ChatRoom";
		String Name = "TestGroup";
		
		@JSONField(name = "Owner_Account") 
		public String getOwner_Account() {
			return Owner_Account;
		}
		public void setOwner_Account(String owner_Account) {
			Owner_Account = owner_Account;
		}
		@JSONField(name = "Type") 
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		@JSONField(name = "Name") 
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		
		public String toJson() {				
			return JSON.toJSONString(this);
			//System.out.println(JSON.toJSONString(this));
			//return "{\"Owner_Account\": \""+Owner_Account+"\",\"Type\":\""+Type+"\", \"Name\": \""+Name+"\"}";
		}
		
		
		
	}
	
	public static void main(String[] args) {
		//String json = "{\"ActionStatus\":\"OK\",\"ErrorCode\":0,\"GroupId\":\"@TGS#3GK7M6QFD\"}";
		//GroupResponseBodyDto body = JSON.parseObject(json, GroupResponseBodyDto.class);		
		//System.out.println(body);
		
		TencentCloud tc = new TencentCloud();
		String json = tc.createGroup("Web_trtc_01");
		System.out.println(json);
		GroupResponseBodyDto body = JSON.parseObject(json, GroupResponseBodyDto.class);		
		System.out.println(body);
	}
	
	
}
