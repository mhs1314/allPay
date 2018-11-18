package com.qht.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 趙家豪
 */
public class MyIndexMessageModel implements Serializable {
    //消息來源頭像
    private String head;
    //消息id
    private String uid;
    //是否閲讀 1已讀 2未讀
    private String isread;
    //學校名稱
    private String nickname;
    //消息發送時間
    private Date time;
    //消息内容
    private String content;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
