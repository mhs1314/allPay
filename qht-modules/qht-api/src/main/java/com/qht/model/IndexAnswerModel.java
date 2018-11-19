package com.qht.model;

import java.io.Serializable;

public class IndexAnswerModel implements Serializable {
    //课程疑惑答复id
    private String uid;
    //封面
    private String cover;
    //内容
    private String question;
    //课时名称
    private String name;
    //是否解答 1否 2是
    private String type;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
		return "IndexAnswerModel [uid=" + uid + ", cover=" + cover + ", question=" + question + ", name=" + name
				+ ", type=" + type + "]";
	}
    
    
}
