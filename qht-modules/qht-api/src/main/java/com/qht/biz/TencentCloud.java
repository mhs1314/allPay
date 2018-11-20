package com.qht.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.qht.common.util.HttpUtil;
import com.qht.dto.GroupBodyDto;
import com.qht.dto.GroupBodyPatameter;
import com.qht.dto.MsgBodyDto;
import com.qht.dto.MsgBodyParameter;


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
	int sdkappid = 1400161647;
	String identifier = "administrator";
	String usersig = "";
	String random = "";
	String contenttype = "json";
	/**
	 * 创建群组地址
	 * @return
	 */
	public String toGroupOpenUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl).append("/");
		sb.append(ver).append("/");
		sb.append(servicename).append("/");
		sb.append(command).append("?");
		sb.append("usersig="+getUsersig(identifier)).append("&");		
		sb.append("identifier="+identifier).append("&");
		sb.append("sdkappid="+webRTCBiz.getSdkAppid()).append("&");
		sb.append("random="+random()).append("&");
		sb.append("contenttype="+contenttype);
		return sb.toString();
	}
	/**
	 * 创建消息推送地址
	 * @return
	 */
	public String toImPushUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl).append("/");
		sb.append(ver).append("/");
		sb.append("group_open_http_svc").append("/");
		sb.append("send_group_system_notification").append("?");
		sb.append("usersig="+getUsersig(identifier)).append("&");		
		sb.append("identifier="+identifier).append("&");
		sb.append("sdkappid="+webRTCBiz.getSdkAppid()).append("&");
		sb.append("random="+random()).append("&");
		sb.append("contenttype="+contenttype);
		return sb.toString();
	}
	
	
	
	private String getUsersig(String userid) {	
		webRTCBiz.setSdkAppid(sdkappid);
		webRTCBiz.setPrivateKey(TencentWebRTCBiz.privateKey());
		webRTCBiz.setPublicKey(TencentWebRTCBiz.publicKeyFile());		
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
	/**
	 * 创建群组
	 * @param teacherId
	 * @return
	 */
	public String createGroup(String teacherId) {
		GroupBodyPatameter param = new GroupBodyPatameter();
		param.setOwner_Account(teacherId);
		return HttpUtil.post(toGroupOpenUrl(), param.toJson());
	}
	
	/**
	 * 消息推送
	 * @return
	 */
	public String imPush(String groupId,String content,List<String> toMembers_Account) {
		MsgBodyParameter param = new MsgBodyParameter();
		param.setGroupId(groupId);
		param.setContent(content);
		if(toMembers_Account == null) {
			param.setToMembers_Account(new ArrayList<String>());	
		}else {
			param.setToMembers_Account(toMembers_Account);
		}			
		return HttpUtil.post(toImPushUrl(), param.toJson());
	}
	
	
	
	public static void main(String[] args) {
		TencentCloud tc = new TencentCloud();
		String json = tc.createGroup("TC001");
		System.out.println(json);
		GroupBodyDto body = JSON.parseObject(json, GroupBodyDto.class);		
		System.out.println(body);		
		String json1 = tc.imPush("@TGS#36DDZ7QFG", "测试消息", null);
		MsgBodyDto body1 = JSON.parseObject(json1, MsgBodyDto.class);
		System.out.println(body1);
	}
	
	
}
