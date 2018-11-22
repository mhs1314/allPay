package com.qht.dto;

import java.io.Serializable;

/**
 * 老师排行
 */
public class TeacherRankingDto implements Serializable {

    //学校名字
    private String school_name;
    //老师名字
    private String nickname;

    private String uid;

    @Override
    public String toString() {
        return "TeacherRankingDto{" +
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
