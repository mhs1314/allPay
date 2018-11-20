package com.qht.model;

import java.io.Serializable;

/**
 * 获取courseList参数的实体类
 */
public class ClassListParam implements Serializable {
    //课程包类型
    private String pkt_type_id;
    //课程包科目
    private String pkg_subject_id;
    //课程包年级
    private String pkg_grade_id;
    //最新
    private String newtime;
    //总价格
    private String price;
    //当前页
    private String page;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "ClassListParam{" +
                "pkt_type_id='" + pkt_type_id + '\'' +
                ", pkg_subject_id='" + pkg_subject_id + '\'' +
                ", pkg_grade_id='" + pkg_grade_id + '\'' +
                ", newtime='" + newtime + '\'' +
                ", price='" + price + '\'' +
                ", page='" + page + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }

    private String tenant_id;

    public String getPkt_type_id() {
        return pkt_type_id;
    }

    public void setPkt_type_id(String pkt_type_id) {
        this.pkt_type_id = pkt_type_id;
    }

    public String getPkg_subject_id() {
        return pkg_subject_id;
    }

    public void setPkg_subject_id(String pkg_subject_id) {
        this.pkg_subject_id = pkg_subject_id;
    }

    public String getPkg_grade_id() {
        return pkg_grade_id;
    }

    public void setPkg_grade_id(String pkg_grade_id) {
        this.pkg_grade_id = pkg_grade_id;
    }

    public String getNewtime() {
        return newtime;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }


}
