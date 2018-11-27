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
 * 提现记录
 * </p>
 *
 * @author qht
 * @since 2018-11-23
 */
@ApiModel("提现记录")
@TableName("extract_record")
public class ExtractRecord extends Model<ExtractRecord> {

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
     * 教师ID
     */
    @ApiModelProperty("教师ID")
    @TableField("teacher_id")
    private String teacherId;
    /**
     * 支付积分
     */
    @ApiModelProperty("支付积分")
    private BigDecimal integral;
    /**
     * 兑换金额
     */
    @ApiModelProperty("兑换金额")
    private BigDecimal money;
    /**
     * 支付方式
     */
    @ApiModelProperty("支付方式")
    @TableField("payment_method_id")
    private String paymentMethodId;
    /**
     * 提现时间
     */
    @ApiModelProperty("提现时间")
    private Date time;
    /**
     * 提现状态
     */
    @ApiModelProperty("提现状态")
    private Integer status;


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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
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

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "ExtractRecord{" +
        ", uid=" + uid +
        ", tenantId=" + tenantId +
        ", teacherId=" + teacherId +
        ", integral=" + integral +
        ", money=" + money +
        ", paymentMethodId=" + paymentMethodId +
        ", time=" + time +
        ", status=" + status +
        "}";
    }
}
