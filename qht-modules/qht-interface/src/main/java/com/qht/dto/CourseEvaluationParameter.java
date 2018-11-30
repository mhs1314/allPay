package com.qht.dto;

import java.io.Serializable;

/**
 * @ClassName CourseEvaluationParameter
 * @Author Zuoxh
 * @Data 2018/11/15 0015 下午 9:24
 */
public class CourseEvaluationParameter implements Serializable {

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
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

    @Override
    public String toString() {
        return "CourseEvaluationParameter{" +
                "tenant_id='" + tenant_id + '\'' +
                ", uid='" + uid + '\'' +
                ", eval='" + eval + '\'' +
                ", page='" + page + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }

    private String tenant_id;

    private String uid;

    private String eval;

    private String page="1";

    private String limit="10";
}
