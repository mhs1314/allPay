package com.qht.dto;

import java.io.Serializable;

public class AppUpateHeadParameter  implements Serializable {
    //学生id
    private String uid;
    //运营商id
    private String tenant_id;
    //头像
    private String head;

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

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
