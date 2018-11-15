package com.qht.dto;

import java.io.Serializable;

public class AppMyStudentGuardianDto implements Serializable {
    //监护人称呼
    private String call;
    //监护人id
    private String uid;
    //电话
    private String phone;
    //'1、主监护人；0、非监护人',
    private String type;

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
