package com.qht.model;

import java.io.Serializable;

public class MyIndexBuyRecordParameterModel implements Serializable{

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPkg_subject_id() {
        return pkg_subject_id;
    }

    public void setPkg_subject_id(String pkg_subject_id) {
        this.pkg_subject_id = pkg_subject_id;
    }

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    public String getPkt_type_id() {
        return pkt_type_id;
    }

    public void setPkt_type_id(String pkt_type_id) {
        this.pkt_type_id = pkt_type_id;
    }

    private String uid;

    private String pkg_subject_id;

    private String play_type_id;

    private String pkt_type_id;

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

    private String page;
    private String limit;

    private String tenant_id;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "MyIndexBuyRecordParameter{" +
                "uid='" + uid + '\'' +
                ", pkg_subject_id='" + pkg_subject_id + '\'' +
                ", play_type_id='" + play_type_id + '\'' +
                ", pkt_type_id='" + pkt_type_id + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }
}
