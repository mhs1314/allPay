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
 * 积分套餐
 * </p>
 *
 * @author qht
 * @since 2018-11-23
 */
@ApiModel("积分套餐")
@TableName("integral_bag")
public class IntegralBag extends Model<IntegralBag> {

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
     * 是否促销
     */
    @ApiModelProperty("是否促销")
    private Integer promotion;
    /**
     * 时间
     */
    @ApiModelProperty("时间")
    private Date time;


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

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "IntegralBag{" +
        ", uid=" + uid +
        ", tenantId=" + tenantId +
        ", integral=" + integral +
        ", money=" + money +
        ", promotion=" + promotion +
        ", time=" + time +
        "}";
    }
}
