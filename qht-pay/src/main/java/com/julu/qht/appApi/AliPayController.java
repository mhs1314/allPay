package com.julu.qht.appApi;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.gson.Gson;
import com.julu.qht.entity.ExtractRecord;
import com.julu.qht.entity.IntegralBag;
import com.julu.qht.entity.RechargeRecord;
import com.julu.qht.entity.dto.CodeMessage;
import com.julu.qht.entity.vo.AliPayFormVo;
import com.julu.qht.entity.vo.Alipay;
import com.julu.qht.service.IExtractRecordService;
import com.julu.qht.service.IIntegralBagService;
import com.julu.qht.service.IRechargeRecordService;
import com.julu.qht.util.AliPayConfig;
import com.julu.qht.util.IDUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class AliPayController {
	protected Log log = LogFactory.getLog(getClass());
	@Autowired
	AliPayConfig aliPayConfig;

	@Autowired
	private IIntegralBagService integralBagService;

	@Autowired
	private IRechargeRecordService rechargeRecordService;
	
	@Autowired
	private IExtractRecordService extractRecordService;

	/**
	 * app学生购买积分
	 * 
	 * @param uid
	 * @return
	 */
	@PostMapping("/pay/student/app_buy_score")
	public CodeMessage app_pay(String uid, String studentId) {

		AliPayFormVo aliPayFormVo = new AliPayFormVo();
		// 根据uid查询积分对应的价格并设置到aliPayFormVo中
		IntegralBag integralBag = integralBagService.selectOne(new EntityWrapper<IntegralBag>().eq("uid", uid));
		// 支付金额
		aliPayFormVo.setTotal_amount(integralBag.getMoney() + "");
		// 商品名称
		aliPayFormVo.setSubject("积分套餐");
		// 商品介绍
		aliPayFormVo.setBody("积分");
		// 订单号
		aliPayFormVo.setOut_trade_no("CZ" + IDUtils.genImageName());
		aliPayFormVo.setReturnUrl("/pay/student/alipayNotify");
		AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getGatewayUrl(), aliPayConfig.getAppID(),
				aliPayConfig.getMerchantPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(),
				aliPayConfig.getAlipayPublicKey(), aliPayConfig.getSignType()); // 获得初始化的AlipayClient

		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setNotifyUrl(aliPayConfig.getNotifyUrl());// 在公共参数中设置回跳和通知地址
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setOutTradeNo(aliPayFormVo.getOut_trade_no());
		model.setTotalAmount(aliPayFormVo.getTotal_amount());
		model.setSubject(aliPayFormVo.getSubject());
		model.setProductCode("QUICK_MSECURITY_PAY");
		model.setBody(aliPayFormVo.getBody());
		alipayRequest.setBizModel(model);

		String orderStr = "";
		try {
			// #app支付
			orderStr = alipayClient.sdkExecute(alipayRequest).getBody(); // 调用SDK生成表单
           System.out.println(orderStr);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		// 添加积分
		RechargeRecord rechargeRecord = new RechargeRecord();
		rechargeRecord.setUid(aliPayFormVo.getOut_trade_no());
		rechargeRecord.setMoney(integralBag.getMoney());
		rechargeRecord.setIntegral(integralBag.getIntegral());
		rechargeRecord.setTime(new Date());
		rechargeRecord.setPaymentMethodId("手机支付宝支付");
		rechargeRecord.setStudentId(studentId);
		rechargeRecord.setState(1);
		rechargeRecordService.insert(rechargeRecord);

		Map<String, String> map = new HashMap<>();
		map.put("orderStr", orderStr);
		return CodeMessage.success("成功", map);
	}
	/**
	 * pc学生购买积分
	 * 
	 * @param uid
	 * @return
	 *//*
	@PostMapping("/pay/student/pc_buy_score")
	public CodeMessage pc_pay(String uid, String studentId) {

		System.out.println(uid);
		System.out.println(studentId);
		AliPayFormVo aliPayFormVo = new AliPayFormVo();
		// 根据uid查询积分对应的价格并设置到aliPayFormVo中
		IntegralBag integralBag = integralBagService.selectOne(new EntityWrapper<IntegralBag>().eq("uid", uid));
		System.out.println(integralBag.getMoney());
		// 支付金额
		aliPayFormVo.setTotal_amount(integralBag.getMoney() + "");
		// 商品名称
		aliPayFormVo.setSubject("积分套餐");
		// 商品介绍
		aliPayFormVo.setBody("积分");
		// 订单号
		aliPayFormVo.setOut_trade_no("CZ" + IDUtils.genImageName());
		aliPayFormVo.setReturnUrl("/student/alipayNotify");
		AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getGatewayUrl(), aliPayConfig.getAppID(),
				aliPayConfig.getMerchantPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(),
				aliPayConfig.getAlipayPublicKey(), aliPayConfig.getSignType()); // 获得初始化的AlipayClient

		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request

		alipayRequest.setReturnUrl(aliPayFormVo.getReturnUrl());

		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\"" + aliPayFormVo.getOut_trade_no() + "\","
				+ "    \"product_code\":\"QUICK_MSECURITY_PAY\"," + "    \"total_amount\":"
				+ aliPayFormVo.getTotal_amount() + "," + "    \"subject\":\"" + aliPayFormVo.getSubject() + "\","
				+ "    \"body\":\"" + aliPayFormVo.getBody() + "\"," + "    \"extend_params\":{"
				+ "    \"sys_service_provider_id\":\"" + aliPayConfig.getSysServiceProviderId() + "\"" + "    }"
				+ "  }");

		String orderStr = "";
		try {
			// #pc支付
			orderStr = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单

		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		// 添加积分
		RechargeRecord rechargeRecord = new RechargeRecord();
		rechargeRecord.setUid(aliPayFormVo.getOut_trade_no());
		rechargeRecord.setMoney(integralBag.getMoney());
		rechargeRecord.setIntegral(integralBag.getIntegral());
		rechargeRecord.setTime(new Date());
		rechargeRecord.setPaymentMethodId("pc支付宝支付");
		rechargeRecord.setStudentId(studentId);
		rechargeRecord.setState(1);
		rechargeRecordService.insert(rechargeRecord);

		Map<String, String> map = new HashMap<>();
		map.put("orderStr", orderStr);
		return CodeMessage.success("成功", map);
	}*/

	/**
	 * 支付宝支付异步回调
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/pay/student/alipayNotify")
	public void alipayNotify(HttpServletRequest request, HttpServletResponse response) {
		System.err.println("支付宝进入异步通知");
		String resultFail = "fail";
		String resultSuccess = "success";
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			/*
			 * try { valueStr = new String(valueStr.getBytes("ISO-8859-1"),
			 * "GBK"); } catch (UnsupportedEncodingException e) {
			 * e.printStackTrace(); }
			 */
			params.put(name, valueStr);
		}

		boolean signVerified = false; // 调用SDK验证签名
		try {
			signVerified = AlipaySignature.rsaCheckV1(params, aliPayConfig.getAlipayPublicKey(),
					aliPayConfig.getCharset(), aliPayConfig.getSignType());
		} catch (AlipayApiException e) {
			responseBody(response, resultFail);
			return;
			// e.printStackTrace();
		}
		if (!signVerified) {
			responseBody(response, resultFail);
			return;
		}

		BigDecimal trade_price = new BigDecimal(request.getParameter("total_amount"));
		// 商户订单号
		String out_trade_no = params.get("out_trade_no");
		// 支付宝交易号
		String trade_no = params.get("trade_no");
		// 交易状态
		String trade_status = params.get("trade_status");
		// 根据订单id 修改支付状态
		// 支付状态 1:支付中 2:支付完成 3:支付失败
		RechargeRecord rechargeRecord = new RechargeRecord();
		// 支付成功修改订单状态
		if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
			// 业务处理，主要是更新订单状态
			rechargeRecord.setState(2);
		} else {
			rechargeRecord.setState(3);
		}
		rechargeRecordService.update(rechargeRecord, new EntityWrapper<RechargeRecord>().eq("uid", out_trade_no));
		// 修改购买人
		responseBody(response, resultFail);
		return;
	}

	private void responseBody(HttpServletResponse response, String contentBody) {
		try {
			response.setContentType("type=text/html;charset=UTF-8");
			String s = contentBody;
			response.getWriter().write(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	@PostMapping("/pay/teacher/cashWithdrawal")
	public CodeMessage  cashWithdrawal(String payeeAccount,String amount,String payeeRealName,String uid){
		String PAYEE_TYPE = "ALIPAY_LOGONID";//支付宝登录号，支持邮箱和手机号格式。

		//实例化接口
		AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getGatewayUrl(), aliPayConfig.getAppID(),
				aliPayConfig.getMerchantPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(),
				aliPayConfig.getAlipayPublicKey(), aliPayConfig.getSignType()); // 获得初始化的AlipayClient

		AlipayFundTransToaccountTransferRequest  request = new AlipayFundTransToaccountTransferRequest ();// 创建API对应的request

		Alipay alipay = new Alipay();
		alipay.setOut_biz_no(IDUtils.genImageName());
		alipay.setPayee_type(PAYEE_TYPE);
		// 金额
		alipay.setAmount(amount);
		// 转账名称
		alipay.setPayer_show_name("老师提现");
		// 收款方账户
		alipay.setPayee_account(payeeAccount);
		// 真实姓名
		alipay.setPayee_real_name(payeeRealName);
		// 转账备注
		alipay.setRemark("老师积分提现");
		//转成json格式放入
		String json = new Gson().toJson(alipay);
		request.setBizContent(json);
		AlipayFundTransToaccountTransferResponse response=null;
		Map<String, Object> map = new HashMap<String,Object>();
		// 修改提现状态 
		ExtractRecord extractRecord = new ExtractRecord();
		try{
			response = alipayClient.execute(request);
			if("10000".equals(response.getCode())){
				// 提现状态 1:成功 2:失败
				extractRecord.setStatus(1);
				extractRecordService.update(extractRecord, new EntityWrapper<ExtractRecord>().eq("uid", uid));
				return CodeMessage.success("提现成功");
			}else{
				// 提现状态 1:成功 2:失败
				extractRecord.setStatus(2);
				extractRecordService.update(extractRecord, new EntityWrapper<ExtractRecord>().eq("uid", uid));
				CodeMessage codeMessage = new CodeMessage<>();
				map.put("sub_code", response.getSubCode());//详情状态码
				map.put("sub_msg", response.getSubMsg());//详情原因
				codeMessage.setCode(500);
				codeMessage.setData(map);
				codeMessage.setMsg("提现失败");
				return codeMessage;
			}
		}catch(AlipayApiException e){
			e.printStackTrace();
			extractRecord.setStatus(2);
			extractRecordService.update(extractRecord, new EntityWrapper<ExtractRecord>().eq("uid", uid));
			CodeMessage codeMessage = new CodeMessage<>();
			map.put("sub_code", response.getSubCode());//详情状态码
			map.put("sub_msg", response.getSubMsg());//详情原因
			codeMessage.setCode(500);
			codeMessage.setData(map);
			codeMessage.setMsg("提现失败");
			return codeMessage;
		}
	}


	/** 支付宝退款接口
	 * @param out_trade_no 订单支付时传入的商户订单号,不能和支付宝交易号（trade_no）同时为空。
	 * @param trade_no 支付宝交易号
	 * @param refund_amount 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
	 * @return 将提示信息返回
	 */
	public String alipayRefundRequest(String out_trade_no,String trade_no,double refund_amount) {
		String returnStr = null;

		String out_request_no="BZ35581R88001";//随机数 不是全额退款，部分退款使用该参数
		try {
			AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getGatewayUrl(), aliPayConfig.getAppID(),
					aliPayConfig.getMerchantPrivateKey(), aliPayConfig.getFormat(), aliPayConfig.getCharset(),
					aliPayConfig.getAlipayPublicKey(), aliPayConfig.getSignType()); // 获得初始化的AlipayClient		   
			AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
			request.setBizContent("{" +
					"\"out_trade_no\":\"" + out_trade_no + "\"," +
					"\"trade_no\":\"" + trade_no + "\"," +
					"\"refund_amount\":\"" + refund_amount + "\"," +

		          "\"out_request_no\":\"" + out_request_no+ "\"," +
		          "\"refund_reason\":\"正常退款\"" +
					" }");
			AlipayTradeRefundResponse response;
			response = alipayClient.execute(request);
			if (response.isSuccess()) {
				System.out.println("支付宝退款成功");
			} else {
				returnStr = response.getSubMsg();//失败会返回错误信息
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}
}