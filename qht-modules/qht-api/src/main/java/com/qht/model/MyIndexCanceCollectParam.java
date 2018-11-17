package com.qht.model;

import java.io.Serializable;

/**
 * @ClassName MyIndexCanceCollectParam
 * @Author Zuoxh
 * @Data 2018/11/15 0015 下午 2:23
 */
public class MyIndexCanceCollectParam implements Serializable {

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "MyIndexCanceCollectParam{" +
                "uid='" + uid + '\'' +
                ", student_id='" + student_id + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }

    private String uid;

    private String student_id;

    private String tenant_id;
}
