package com.qht.dto;

import java.io.Serializable;

public class SelectPkgByStuIdDto implements Serializable {
	//课程包封面
	private String cover;
	//课程包id
	private String uid;
	//课程包名称
	private String pkg_name;
	//播放类型
	private String play_type_id;
	//总价格
	private String total_price;
	//购买人数
	private String apply_number;
	//评分
	private String comments_star;
	//点赞数
	private String praise_number;
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public String getApply_number() {
		return apply_number;
	}
	public void setApply_number(String apply_number) {
		this.apply_number = apply_number;
	}
	public String getComments_star() {
		return comments_star;
	}
	public void setComments_star(String comments_star) {
		this.comments_star = comments_star;
	}
	public String getPraise_number() {
		return praise_number;
	}
	public void setPraise_number(String praise_number) {
		this.praise_number = praise_number;
	}
	@Override
	public String toString() {
		return "SelectPkgByStuIdModel [cover=" + cover + ", uid=" + uid + ", pkg_name=" + pkg_name + ", play_type_id="
				+ play_type_id + ", total_price=" + total_price + ", apply_number=" + apply_number + ", comments_star="
				+ comments_star + ", praise_number=" + praise_number + "]";
	}
	

}
