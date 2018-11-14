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
    //运营方id
    private String tenantId;


    public String getStudentId() {
		return studentId;
	}




	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}




	@Override
    public String toString() {
        return "StudentDto{" +
                "uid='" + uid + '\'' +
                ", schoolid='" + schoolid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
