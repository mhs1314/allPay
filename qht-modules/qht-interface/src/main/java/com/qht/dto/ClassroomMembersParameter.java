package com.qht.dto;



public class ClassroomMembersParameter {
	//昵称
    private String nickname;
	
	//麦克风是否可用 0 否 1是    
    private Integer mic;
	
	//学生ID    
    private String student_id;
	
	//摄像头是否可用 0 否 1 是    
    private String camera;
	
	//上线 0 否 1 是   
    private Integer status;
	
	//课堂ID   
    private String classroom_id;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getMic() {
		return mic;
	}

	public void setMic(Integer mic) {
		this.mic = mic;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getClassroom_id() {
		return classroom_id;
	}

	public void setClassroom_id(String classroom_id) {
		this.classroom_id = classroom_id;
	}
    
    
    
    
}
