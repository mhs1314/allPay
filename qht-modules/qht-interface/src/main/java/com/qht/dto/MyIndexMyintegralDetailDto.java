package com.qht.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MyIndexMyintegralDetailDto implements Serializable {
    private String uid;
    private String pkg_name;
    private BigDecimal total_price;
    private Date time;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
