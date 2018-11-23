package com.julu.qht.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 充值积分兑换表
 * </p>
 *
 * @author qht
 * @since 2018-11-23
 */
@ApiModel("充值积分兑换表")
@TableName("money_score")
public class MoneyScore extends Model<MoneyScore> {

    private static final long serialVersionUID = 1L;

    /**
     * 充值积分兑换表id
     */
    @ApiModelProperty("充值积分兑换表id")
    private String uid;
    /**
     * 钱
     */
    @ApiModelProperty("钱")
    private Integer money;
    /**
     * 积分
     */
    @ApiModelProperty("积分")
    private Integer score;
    /**
     * 运营商ID
     */
    @ApiModelProperty("运营商ID")
    @TableField("tenant_id")
    private String tenantId;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "MoneyScore{" +
        ", uid=" + uid +
        ", money=" + money +
        ", score=" + score +
        ", tenantId=" + tenantId +
        "}";
    }
}
