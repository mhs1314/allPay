package com.qht.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 在线课堂
 * 
 * @author yangtonggan
 * @email 2466607841@qq.com
 * @date 2018-11-19 18:25:28
 */
@Table(name = "classroom")
public class Classroom implements Serializable {
	private static final long serialVersionUID = 1L;
	
	    //课堂ID
    @Id
    private String uid;
	
	    //课时ID
    @Column(name = "period_id")
    private String periodId;
	
	    //教师ID
    @Column(name = "teacher_id")
    private String teacherId;
	
	    //屏幕状态
    @Column(name = "home_screen")
    private String homeScreen;
	
	    //直播房间ID
    @Column(name = "room_id")
    private int roomId;
	
	    //IM群组ID
    @Column(name = "im_group_id")
    private String imGroupId;
	
	    //白板群组ID
    @Column(name = "whiteboard_id")
    private String whiteboardId;
    //创建时间
    @Column(name = "create_time")
    private Date createTime;         
	

	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 设置：课堂ID
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：课堂ID
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：课时ID
	 */
	public void setPeriodId(String periodId) {
		this.periodId = periodId;
	}
	/**
	 * 获取：课时ID
	 */
	public String getPeriodId() {
		return periodId;
	}
	/**
	 * 设置：教师ID
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：教师ID
	 */
	public String getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：屏幕状态
	 */
	public void setHomeScreen(String homeScreen) {
		this.homeScreen = homeScreen;
	}
	/**
	 * 获取：屏幕状态
	 */
	public String getHomeScreen() {
		return homeScreen;
	}
	/**
	 * 设置：直播房间ID
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	/**
	 * 获取：直播房间ID
	 */
	public int getRoomId() {
		return roomId;
	}
	/**
	 * 设置：IM群组ID
	 */
	public void setImGroupId(String imGroupId) {
		this.imGroupId = imGroupId;
	}
	/**
	 * 获取：IM群组ID
	 */
	public String getImGroupId() {
		return imGroupId;
	}
	/**
	 * 设置：白板群组ID
	 */
	public void setWhiteboardId(String whiteboardId) {
		this.whiteboardId = whiteboardId;
	}
	/**
	 * 获取：白板群组ID
	 */
	public String getWhiteboardId() {
		return whiteboardId;
	}
}
