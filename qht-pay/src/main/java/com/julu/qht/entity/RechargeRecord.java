package com.julu.qht.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 充值记录
 * </p>
 *
 * @author qht
 * @since 2018-11-23
 */
@ApiModel("充值记录")
@TableName("recharge_record")
public class RechargeRecord extends Model<RechargeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String uid;
    /**
     * 运营商ID
     */
    @ApiModelProperty("运营商ID")
    @TableField("tenant_id")
    private String tenantId;
    /**
     * 学生ID
     */
    @ApiModelProperty("学生ID")
    @TableField("student_id")
    private String studentId;
    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private BigDecimal integral;
    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private BigDecimal money;
    /**
     * 充值时间
     */
    @ApiModelProperty("充值时间")
    private Date time;
    /**
     * 支付方式
     */
    @ApiModelProperty("支付方式")
    @TableField("payment_method_id")
    private String paymentMethodId;
    /**
     * 支付状态 1:支付中 2:支付完成 3:支付失败
     */
    @ApiModelProperty("支付状态 1:支付中 2:支付完成 3:支付失败")
    private Integer state;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getIntegral() {
        return integral;
    }

    public void setIntegral(BigDecimal integral) {
        this.integral = integral;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "RechargeRecord{" +
        ", uid=" + uid +
        ", tenantId=" + tenantId +
        ", studentId=" + studentId +
        ", integral=" + integral +
        ", money=" + money +
        ", time=" + time +
        ", paymentMethodId=" + paymentMethodId +
        ", state=" + state +
        "}";
    }
}
