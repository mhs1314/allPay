package com.qht.dto;

import java.io.Serializable;

public class IndexTeacherListParameter  implements Serializable {
    //运营商id
    private String tid;
    //年级ID
    private String pkg_grade_id;

    public String getPkg_grade_id() {
        return pkg_grade_id;
    }

    public void setPkg_grade_id(String pkg_grade_id) {
        this.pkg_grade_id = pkg_grade_id;
    }

    //科目ID
    private String subject_id;
    // 大于点赞数
    private String praise_number;    


    public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getPraise_number() {
        return praise_number;
    }

    public void setPraise_number(String praise_number) {
        this.praise_number = praise_number;
    }
}
