package com.qht.model;

import java.io.Serializable;

public class GuardianModel  implements Serializable {
    //监护人id
    private String gid;
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

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

	@Override
	public String toString() {
		return "GuardianDto [gid=" + gid + ", call=" + call + ", phone=" + phone + "]";
	}
    
    
}
