package com.qht.dto;

import java.io.Serializable;

public class GuardianDto  implements Serializable {
    //监护人关系
    private String call;
    //监护人电话
    private String phone;

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
