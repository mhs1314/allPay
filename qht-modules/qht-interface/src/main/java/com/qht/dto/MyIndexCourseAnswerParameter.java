package com.qht.dto;

import java.io.Serializable;

public class MyIndexCourseAnswerParameter implements Serializable {

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "MyIndexCourseAnswerParameter{" +
                "uid='" + uid + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    private String uid;

    private String answer;
}
