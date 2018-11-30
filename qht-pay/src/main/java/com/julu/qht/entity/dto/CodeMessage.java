package com.julu.qht.entity.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "app接口返回")
public class CodeMessage<T> {
    @ApiModelProperty(value = "编码：200（成功）、401 (参数名不对)、402（参数值不对）、404(未查询到数据)、500(失败)、501（请登录）、502（系统内部错误）、503（业务不支持）")
    private Integer code;
    @ApiModelProperty(value = "消息内容：根据实际场景相应编码的详细描述")
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "数据集合：返回业务场景中前端需要的数据")
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static CodeMessage erro(int code, String msg) {
        CodeMessage codeMessage =new CodeMessage();
        codeMessage.setCode(code);
        codeMessage.setMsg(msg);
        return codeMessage;
    }

    /**
     * 成功有返回
     * @param msg
     * @param data
     * @return
     */
    public static CodeMessage success(String msg,Object data) {
        CodeMessage codeMessage =new CodeMessage();
        codeMessage.setCode(0);
        codeMessage.setMsg(msg);
        codeMessage.setData(data);
        return codeMessage;
    }

    /**
     * 成功没有返回
     * @param msg
     * @return
     */
    public static CodeMessage success(String msg) {
        CodeMessage codeMessage =new CodeMessage();
        codeMessage.setCode(200);
        codeMessage.setMsg(msg);
        return codeMessage;
    }

    /**
     * 401
     * 参数名不对
     * @return
     */
    public static CodeMessage erro_no_parms(String parms){
        return erro(401, "缺少参数："+parms);
    }

    /**
     * 402
     * 参数值不对
     * @return
     */
    public static CodeMessage erro_bad_parms(String parms){
        return erro(402, "参数值不对："+parms);
    }

    /**
     * 501
     * 请登录
     * @return
     */
    public static CodeMessage erro_no_login(){
        return erro(501, "请登录");
    }

    /**
     * 502
     * 系统内部错误
     * @return
     */
    public static CodeMessage erro_service_erro(){
        return erro(502, "系统内部错误");
    }

    /**
     * 503
     * 业务不支持
     * @return
     */
    public static CodeMessage erro_no_support(){
        return erro(503, "业务不支持");
    }
}
