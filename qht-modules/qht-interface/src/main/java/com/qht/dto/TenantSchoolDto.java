package com.qht.dto;

import java.io.Serializable;

public class TenantSchoolDto implements Serializable {

    private String uid;

    private String intr;

    private String culture;

    private String banner;

    private String school_name;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    @Override
    public String toString() {
        return "TenantSchoolDto{" +
                "uid='" + uid + '\'' +
                ", intr='" + intr + '\'' +
                ", culture='" + culture + '\'' +
                ", banner='" + banner + '\'' +
                ", school_name='" + school_name + '\'' +
                '}';
    }
}
