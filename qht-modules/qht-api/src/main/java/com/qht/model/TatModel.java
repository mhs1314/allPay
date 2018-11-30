package com.qht.model;

import java.io.Serializable;

public class TatModel  implements Serializable {
    //兴趣id
    private String tid;
    //兴趣姓名
    private String tname;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

	@Override
	public String toString() {
		return "TatModel [tid=" + tid + ", tname=" + tname + "]";
	}
    
    
}
