package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 课程列表
 */
public class ClassListModel implements Serializable {
    //课程包封面
    private String cover;

    //运营商id
    private String tenant_id;
    //课程报名称
    private String pkg_name;
    //课程包类型
    private String pkt_type_id;
    //总价格
    private BigDecimal total_price;
    //老师名称
    private String nickname;
    //难易度
    private Integer easy;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public String getPkt_type_id() {
        return pkt_type_id;
    }

    public void setPkt_type_id(String pkt_type_id) {
        this.pkt_type_id = pkt_type_id;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getEasy() {
        return easy;
    }

    public void setEasy(Integer easy) {
        this.easy = easy;
    }



    @Override
    public String toString() {
        return "ClassListModel{" +
                "cover='" + cover + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", pkt_type_id='" + pkt_type_id + '\'' +
                ", total_price=" + total_price +
                ", nickname='" + nickname + '\'' +
                ", easy=" + easy +
                '}';
    }

}
