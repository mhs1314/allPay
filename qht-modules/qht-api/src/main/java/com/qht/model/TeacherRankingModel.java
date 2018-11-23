package com.qht.model;

import java.io.Serializable;

/**
 * 老师排行
 */
public class TeacherRankingModel implements Serializable {

    //学校名字
    private String school_name;
    //老师名字
    private String nickname;

    private String uid;

    @Override
    public String toString() {
        return "TeacherRankingModel{" +
                "school_name='" + school_name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
