package com.qht.dto;

import java.io.Serializable;

public class IndexMyAnswerDto implements Serializable {

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "IndexMyAnswerDto{" +
                "cover='" + cover + '\'' +
                ", uid='" + uid + '\'' +
                ", question='" + question + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    private String cover;

    private String uid;

    private String question;

    private String name;

    private String type;

}
