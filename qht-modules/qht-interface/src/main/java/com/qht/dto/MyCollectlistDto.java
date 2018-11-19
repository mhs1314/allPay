package com.qht.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MyCollectlistDto implements Serializable {
    //课程包封面
    private String cover;
    //收藏id
    private String uid;
    //课程包名称
    private String pkg_name;
    //总价格
    private String total_price;
    //评分
    private BigDecimal comments_star;
    //课程包id
    private String pkg_id;
    //点赞数
    private Integer praise_number;
    //购买数
    private String apply_number;
    //播放类型
    private String play_type_id;

    public String getPlay_type_id() {
		return play_type_id;
	}

	public void setPlay_type_id(String play_type_id) {
		this.play_type_id = play_type_id;
	}

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

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public BigDecimal getComments_star() {
        return comments_star;
    }

    public void setComments_star(BigDecimal comments_star) {
        this.comments_star = comments_star;
    }

    public String getPkg_id() {
        return pkg_id;
    }

    public void setPkg_id(String pkg_id) {
        this.pkg_id = pkg_id;
    }

    public Integer getPraise_number() {
        return praise_number;
    }

    public void setPraise_number(Integer praise_number) {
        this.praise_number = praise_number;
    }

    public String getApply_number() {
        return apply_number;
    }

    public void setApply_number(String apply_number) {
        this.apply_number = apply_number;
    }

	@Override
	public String toString() {
		return "MyCollectlistDto [cover=" + cover + ", uid=" + uid + ", pkg_name=" + pkg_name + ", total_price="
				+ total_price + ", comments_star=" + comments_star + ", pkg_id=" + pkg_id + ", praise_number="
				+ praise_number + ", apply_number=" + apply_number + "]";
	}
    
    
}
