package com.qht.dto;

public class ClassroomDto {
	//课堂ID
	private String conf_id;
	//直播房间ID
	private Integer room_id;
	//IM群组ID
	private String group_id;
	//白板群组ID
	private String board_group_id;
	//课堂拥有者(教师)
	private String owner;
	//创建时间 
	private String create_time;
	//课堂名称
	private String conf_name;
	//屏幕状态
	private String home_screen;
	
	
	public String getConf_id() {
		return conf_id;
	}

	public void setConf_id(String conf_id) {
		this.conf_id = conf_id;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getBoard_group_id() {
		return board_group_id;
	}

	public void setBoard_group_id(String board_group_id) {
		this.board_group_id = board_group_id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getConf_name() {
		return conf_name;
	}

	public void setConf_name(String conf_name) {
		this.conf_name = conf_name;
	}

	public String getHome_screen() {
		return home_screen;
	}

	public void setHome_screen(String home_screen) {
		this.home_screen = home_screen;
	}
	
	
	
	
}
