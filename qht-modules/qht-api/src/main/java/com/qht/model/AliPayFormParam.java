package com.qht.model;

/**
 * 支付宝支付
 */
public class AliPayFormParam {
    /**
     * 返回url
     */
    private String returnUrl;

    /**
     * 订单号
     */
    private  String out_trade_no;

    /**
     * 商品名称
     */
    private  String product_code;
    /**
     * 支付金额
     */
    private  String total_amount;
    /**
     * 商品名称
     */
    private  String subject;
    /**
     * 商品介绍
     */
    private  String body;

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }



    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
