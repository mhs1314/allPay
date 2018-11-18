package com.qht.model;

import java.io.Serializable;

/**
 * 趙家豪
 */
public class MyIndexMessageParam implements Serializable {
    //學生id
    private  String uid;
    //運營商id
    private String tenant_id;
    // 是否閲讀：1、已讀 2、未讀
    private String isread;
    //当前页
    private String page="1";
    //行数
    private String limit="10";

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }


    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
