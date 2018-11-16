package com.qht.model;

import java.io.Serializable;

public class IndexCoruseListParameterModel  implements Serializable {
    // 运营商id
    private String tenant_id;
    //'课程包播放类型：1、直播；2、录播',
    private String play_type_id;
    //课程包年级id
    private String pkg_grade_id;
    //课程包科目id
    private String pkg_subject_id;
    //课程包课程id
    private String course_type_id;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    public String getPkg_grade_id() {
        return pkg_grade_id;
    }

    public void setPkg_grade_id(String pkg_grade_id) {
        this.pkg_grade_id = pkg_grade_id;
    }

    public String getPkg_subject_id() {
        return pkg_subject_id;
    }

    public void setPkg_subject_id(String pkg_subject_id) {
        this.pkg_subject_id = pkg_subject_id;
    }

    public String getCourse_type_id() {
        return course_type_id;
    }

    public void setCourse_type_id(String course_type_id) {
        this.course_type_id = course_type_id;
    }

	@Override
	public String toString() {
		return "IndexCoruseListParameter [tenant_id=" + tenant_id + ", play_type_id=" + play_type_id + ", pkg_grade_id="
				+ pkg_grade_id + ", pkg_subject_id=" + pkg_subject_id + ", course_type_id=" + course_type_id + "]";
	}
    
    
}
