package com.qht.model;

import java.io.Serializable;
import java.util.Date;

public class InsertCoursePkgParam implements Serializable {
	//课程包主键
	private String uid;
	//教师id
	private String teacher_id;
	//	运营商id
	private String tenant_id;
	//课程包类型id
	private String course_type_id;
	//课程包科目id
	private String pkg_subject_id;
	//	课程包版本id	
	private String pkg_edition_id;
	//课程包年级id
	private String pkg_grade_id;
	//课程包班级id
	private String pkg_level_id;
	//	课程包名称
	private String pkg_name;
	//	1、直播 2、录播
	private String play_type_id;
	//	兑换人数最小值
	private String min;
	//兑换人数最大值
	private String max;
	//	课程包主要内容
	private String content;
	//课程包主要封面
	private String cover;
	//	1、免费；2、试听
	private String pkt_type_id;
	//	范围
	private String open_range_id;
	//'难易程度,0,YES,false,false,false',
	private Integer easy;
	//状态
	private String status;
	//创建时间
	private Date create_time;

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "InsertCoursePkgParam{" +
				"uid='" + uid + '\'' +
				", teacher_id='" + teacher_id + '\'' +
				", tenant_id='" + tenant_id + '\'' +
				", course_type_id='" + course_type_id + '\'' +
				", pkg_subject_id='" + pkg_subject_id + '\'' +
				", pkg_edition_id='" + pkg_edition_id + '\'' +
				", pkg_grade_id='" + pkg_grade_id + '\'' +
				", pkg_level_id='" + pkg_level_id + '\'' +
				", pkg_name='" + pkg_name + '\'' +
				", play_type_id='" + play_type_id + '\'' +
				", min='" + min + '\'' +
				", max='" + max + '\'' +
				", content='" + content + '\'' +
				", cover='" + cover + '\'' +
				", pkt_type_id='" + pkt_type_id + '\'' +
				", open_range_id='" + open_range_id + '\'' +
				", easy=" + easy +
				", status='" + status + '\'' +
				", create_time=" + create_time +
				'}';
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	public String getCourse_type_id() {
		return course_type_id;
	}
	public void setCourse_type_id(String course_type_id) {
		this.course_type_id = course_type_id;
	}
	public String getPkg_subject_id() {
		return pkg_subject_id;
	}
	public void setPkg_subject_id(String pkg_subject_id) {
		this.pkg_subject_id = pkg_subject_id;
	}
	public String getPkg_edition_id() {
		return pkg_edition_id;
	}
	public void setPkg_edition_id(String pkg_edition_id) {
		this.pkg_edition_id = pkg_edition_id;
	}
	public String getPkg_grade_id() {
		return pkg_grade_id;
	}
	public void setPkg_grade_id(String pkg_grade_id) {
		this.pkg_grade_id = pkg_grade_id;
	}
	public String getPkg_level_id() {
		return pkg_level_id;
	}
	public void setPkg_level_id(String pkg_level_id) {
		this.pkg_level_id = pkg_level_id;
	}
	public String getPkg_name() {
		return pkg_name;
	}
	public void setPkg_name(String pkg_name) {
		this.pkg_name = pkg_name;
	}
	public String getPlay_type_id() {
		return play_type_id;
	}
	public void setPlay_type_id(String play_type_id) {
		this.play_type_id = play_type_id;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPkt_type_id() {
		return pkt_type_id;
	}
	public void setPkt_type_id(String pkt_type_id) {
		this.pkt_type_id = pkt_type_id;
	}
	public String getOpen_range_id() {
		return open_range_id;
	}
	public void setOpen_range_id(String open_range_id) {
		this.open_range_id = open_range_id;
	}
	public Integer getEasy() {
		return easy;
	}
	public void setEasy(Integer easy) {
		this.easy = easy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
