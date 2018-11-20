package com.qht.dto;

import java.io.Serializable;

public class IndexTeacherDto implements Serializable {
    //教师id
    private String uid;
    // 教师昵称
    private String nickname;
    //科目名称
    private String subject_name;
    //学校名称
    private String school_name;
    //头像
    private String back_img;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getBack_img() {
        return back_img;
    }

    public void setBack_img(String back_img) {
        this.back_img = back_img;
    }

	@Override
	public String toString() {
		return "IndexTeacherDto [uid=" + uid + ", nickname=" + nickname + ", subject_name=" + subject_name
				+ ", school_name=" + school_name + ", back_img=" + back_img + "]";
	}
    
    
}
