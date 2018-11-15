package com.qht.dto;

import java.io.Serializable;

/**
 * 学生登陆成功返回的信息
 */
public class StudentDto implements Serializable {
    //学生的uid
    private String uid;
    
    private String studentId;
    //学校的id
    private String schoolid;
    //昵称
    private String nickname;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "uid='" + uid + '\'' +
                ", studentId='" + studentId + '\'' +
                ", schoolid='" + schoolid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }

    //运营方id
    private String tenant_id;


    public String getStudentId() {
		return studentId;
	}




	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
