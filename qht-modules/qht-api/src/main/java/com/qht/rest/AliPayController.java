package com.qht.rest;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.qht.RequestObject;
import com.qht.ResultObject;
import com.qht.common.util.AliPayConfig;
import com.qht.model.AliPayFormParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AliPayController {
    protected Log log = LogFactory.getLog(getClass());
    @Autowired
    AliPayConfig aliPayConfig;



    /**
     * 手机端学生购买积分
     * @param uid
     * @return
     */
    @PostMapping("/student/app_pay")
    public ResultObject app_pay(@RequestBody RequestObject<String> uid )  {

        ResultObject resultObject=new ResultObject();
        AliPayFormParam aliPayFormVo=new AliPayFormParam();
        aliPayFormVo.setTotal_amount("650");
        aliPayFormVo.setSubject("积分");
        aliPayFormVo.setBody("支付兑换积分");
        aliPayFormVo.setReturnUrl("");
        //TODO 根据uid查询积分对应的价格并设置到aliPDO 根据uid查询积分对应的价格并设置到aliPayFormVo中ayFormVo中
        AlipayClient alipayClient = new DefaultAlipayClient(
                aliPayConfig.getGatewayUrl(),
                aliPayConfig.getAppID(),
                aliPayConfig.getMerchantPrivateKey(),
                aliPayConfig.getFormat(),
                aliPayConfig.getCharset(),
                aliPayConfig.getAlipayPublicKey(),
                aliPayConfig.getSignType()); //获得初始化的AlipayClient

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request

        alipayRequest.setReturnUrl(aliPayFormVo.getReturnUrl());
        alipayRequest.setNotifyUrl(aliPayConfig.getNotifyUrl());//在公共参数中设置回跳和通知地址

        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+aliPayFormVo.getOut_trade_no()+"\"," +
                "    \"product_code\":\"QUICK_MSECURITY_PAY\"," +
                "    \"total_amount\":"+aliPayFormVo.getTotal_amount()+"," +
                "    \"subject\":\""+aliPayFormVo.getSubject()+"\"," +
                "    \"body\":\""+aliPayFormVo.getBody()+"\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\""+aliPayConfig.getSysServiceProviderId()+"\"" +
                "    }"+
                "  }");

        String orderStr = "";
        try {
        	//#app支付
            orderStr = alipayClient.sdkExecute(alipayRequest).getBody(); //调用SDK生成表单

        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        Map<String,String> map=new HashMap<>();
        map.put("orderStr",orderStr);
        resultObject.setData(map);
        return resultObject;
    }

    /**
     * 支付宝支付异步回调
     *
     * @param request
     * @return
     */
    @RequestMapping("/alipayNotify")
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response) {
        System.err.println("支付宝进入异步通知");
        String resultFail = "fail";
        String resultSuccess = "success";
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            /*try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }*/
            params.put(name, valueStr);
        }

        boolean signVerified = false; //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, aliPayConfig.getAlipayPublicKey(), aliPayConfig.getCharset(), aliPayConfig.getSignType());
        } catch (AlipayApiException e) {
            responseBody(response, resultFail);
            return;
            //e.printStackTrace();
        }
        if (!signVerified) {
            responseBody(response, resultFail);
            return;
        }

        BigDecimal trade_price = new BigDecimal(request.getParameter("total_amount"));
        //商户订单号
        String out_trade_no = params.get("out_trade_no");
        //支付宝交易号
        String trade_no = params.get("trade_no");
        //交易状态
        String trade_status = params.get("trade_status");

        // 支付成功修改订单状态
        if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {

            //业务处理，主要是更新订单状态
        }
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
}