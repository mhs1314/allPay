package com.qht.dto;

/**
 * 学生登录结果
 * 
 * @author 草原狼
 * @date Nov 14, 2018 11:20:16 AM
 */
public class StudentLoginResultDto extends LoginResultDto {
	
	private static final long serialVersionUID = -233773216531291114L;
	// 学生ID
	private String uid;
	// 学校ID
	private String schoolId;
	// 昵称
	private String nickname;
	// 运营商ID
	private String tenantId;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
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
	@Override
	public String toString() {
		return "StudentLoginResultDto [uid=" + uid + ", schoolId=" + schoolId + ", nickname=" + nickname + ", tenantId="
				+ tenantId + "]";
	}
	
	
}
