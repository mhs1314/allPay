package com.qht.model;

import java.io.Serializable;

public class TagModel implements Serializable {
    //兴趣标签id
    private String uid;
    //兴趣标签
    private  String tag_name;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
