package com.qht.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 试听排行榜
 */
public class ListeningClassRankingDto implements Serializable {
    //封面
    private String cover;
    //课时id
    private String uid;
    //课程包名
    private String pkg_name;
    //班级名称
    private String level_name;

    private BigDecimal total_price;

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "ListeningClassRankingDto{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", level_name='" + level_name + '\'' +
                ", total_price='" + total_price + '\'' +
                ", play_type_id='" + play_type_id + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    //播放类型
    private String play_type_id;
    //老师名称
    private String nickname;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }


}
