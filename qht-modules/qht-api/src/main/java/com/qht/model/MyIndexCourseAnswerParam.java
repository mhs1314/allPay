package com.qht.model;

import com.github.pagehelper.Page;

import java.io.Serializable;

public class MyIndexCourseAnswerParam implements Serializable {

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    private String uid;

    private String answer;

    private String page;

    private String limit;

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    @Override
    public String toString() {
        return "MyIndexCourseAnswerParam{" +
                "uid='" + uid + '\'' +
                ", answer='" + answer + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                ", tenant_id='" + tenant_id + '\'' +
                '}';
    }

    private String tenant_id;


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

}
