package com.qht.model;

import java.io.Serializable;

public class IndexCoruseListModel  implements Serializable {
    //封面
    private String cover;
    //课程包id
    private String uid;
    //课程包名称
    private String pkg_name;
    //播放类型 1直播 2录播
    private String play_type_id;
    //老师昵称
    private String nickname;
    //科目名称
    private String subject_name;
    //购买人数
    private String apply_number;

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

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getApply_number() {
        return apply_number;
    }

    public void setApply_number(String apply_number) {
        this.apply_number = apply_number;
    }

	@Override
	public String toString() {
		return "IndexCoruseListDto [cover=" + cover + ", uid=" + uid + ", pkg_name=" + pkg_name + ", play_type_id="
				+ play_type_id + ", nickname=" + nickname + ", subject_name=" + subject_name + ", apply_number="
				+ apply_number + "]";
	}
    
    
}
