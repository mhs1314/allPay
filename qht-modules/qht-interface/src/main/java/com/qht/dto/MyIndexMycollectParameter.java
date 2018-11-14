package com.qht.dto;

import java.io.Serializable;

public class MyIndexMycollectParameter implements Serializable {

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

    public String getPkt_type_id() {
        return pkt_type_id;
    }

    public void setPkt_type_id(String pkt_type_id) {
        this.pkt_type_id = pkt_type_id;
    }

    @Override
    public String toString() {
        return "MyIndexMycollectParameter{" +
                "uid='" + uid + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                ", pkt_type_id='" + pkt_type_id + '\'' +
                '}';
    }

    private String uid;

    private String tenant_id;

    private String page="1";

    private String limit="10";

    private String pkt_type_id;
}
