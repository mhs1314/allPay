package com.qht.model;

import java.io.Serializable;

/**
 * banner
 */
public class BannerModel implements Serializable {
    //图片地址
    private String image;
    //bannerid
    private String uid;
    //链接地址
    private String link;

    //排序
    private Integer sort;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "BannerModel{" +
                "image='" + image + '\'' +
                ", uid='" + uid + '\'' +
                ", link='" + link + '\'' +
                ", sort='" + sort + '\'' +
                '}';
    }


}
