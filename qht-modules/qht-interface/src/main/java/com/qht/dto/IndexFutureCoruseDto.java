package com.qht.dto;

import java.io.Serializable;

public class IndexFutureCoruseDto  implements Serializable {
    //封面
    private String cover;
    //课程表id
    private String uid;
    //课程包名称
    private String pkg_name;
    //教室昵称
    private String nickname;
    //科目
    private String subject_name;
    // 购买人数
    private String apply_number;
    
    private String total_price;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUid() {
        return uid;
    }
    
    public String getTotal_price() {
		return total_price;
	}

	public void setTotal_price(String total_price) {
		this.total_price = total_price;
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
		return "IndexFutureCoruseDto [cover=" + cover + ", uid=" + uid + ", pkg_name=" + pkg_name + ", nickname="
				+ nickname + ", subject_name=" + subject_name + ", apply_number=" + apply_number + "]";
	}
    
    
}
