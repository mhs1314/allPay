package com.qht.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 课堂成员列表
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-19 19:48:15
 */
@Table(name = "classroom_members")
public class ClassroomMembers implements Serializable {
	private static final long serialVersionUID = 1L;
	
	 //主键
    @Id
    private String uid;
	
	//学生昵称
    @Column(name = "nickname")
    private String nickname;
	
	 //麦克风是否可用 0 否 1是
    @Column(name = "mic")
    private Integer mic;
	
	//学生ID
    @Column(name = "student_id")
    private String studentId;
	
	    //摄像头是否可用 0 否 1 是
    @Column(name = "camera")
    private String camera;
	
	    //上线 0 否 1 是
    @Column(name = "status")
    private Integer status;
	
	    //课堂ID
    @Column(name = "classroom_id")
    private String classroomId;
	

	/**
	 * 设置：主键
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：主键
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：学生昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：学生昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：麦克风是否可用 0 否 1是
	 */
	public void setMic(Integer mic) {
		this.mic = mic;
	}
	/**
	 * 获取：麦克风是否可用 0 否 1是
	 */
	public Integer getMic() {
		return mic;
	}
	/**
	 * 设置：学生ID
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	/**
	 * 获取：学生ID
	 */
	public String getStudentId() {
		return studentId;
	}
	/**
	 * 设置：摄像头是否可用 0 否 1 是
	 */
	public void setCamera(String camera) {
		this.camera = camera;
	}
	/**
	 * 获取：摄像头是否可用 0 否 1 是
	 */
	public String getCamera() {
		return camera;
	}
	/**
	 * 设置：上线 0 否 1 是
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：上线 0 否 1 是
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：课堂ID
	 */
	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}
	/**
	 * 获取：课堂ID
	 */
	public String getClassroomId() {
		return classroomId;
	}
}
