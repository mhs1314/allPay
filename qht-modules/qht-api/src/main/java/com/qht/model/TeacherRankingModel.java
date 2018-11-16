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

    @Override
    public String toString() {
        return "TeacherRanking{" +
                "school_name='" + school_name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }


}
