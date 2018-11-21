package com.qht.dto;

import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;


public class MyIndexCourseParameter implements Serializable {

    private String uid;

    private String course_type_id;

    private String play_type_id;

    public String getPlay_type_id() {
		return play_type_id;
	}

	public void setPlay_type_id(String play_type_id) {
		this.play_type_id = play_type_id;
	}

    public String getPkg_subject_id() {
		return pkg_subject_id;
	}

	public void setPkg_subject_id(String pkg_subject_id) {
		this.pkg_subject_id = pkg_subject_id;
	}

	@Override
    public String toString() {
        return "MyIndexCourseParameter{" +
                "uid='" + uid + '\'' +
                ", course_type_id='" + course_type_id + '\'' +
                ", pkg_subject_='" + pkg_subject_id+ '\'' +
                ", now_time='" + now_time + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }

    private String pkg_subject_id;

    private String now_time;
    private String  page="1";
    private String limit="10";

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    private String tenant_id;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCourse_type_id() {
        return course_type_id;
    }

    public void setCourse_type_id(String course_type_id) {
        this.course_type_id = course_type_id;
    }

    public String getNow_time() {
        return now_time;
    }

    public void setNow_time(String now_time) {
        this.now_time = now_time;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
    public static void main(String[] args){
        MyIndexCourseParameter a=new MyIndexCourseParameter();
        a.setNow_time("2018-11-15");
        System.out.println(a.getNow_time());
    }

}
