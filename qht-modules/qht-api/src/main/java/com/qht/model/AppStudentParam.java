package com.qht.model;

import java.io.Serializable;

public class AppStudentParam implements Serializable {
    //学生id
    private String uid;
    //运营商id
    private String tenant_id;
    //头像
    private String head;
    //昵称
    private String nickname;
    //修改密码
    private String password;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
