package com.qht.dto;

import java.io.Serializable;

public class IndexAnswerDetailsAppendAnswerParameter implements Serializable {

    private String uid;

    private String tanant_id;

    private String append_ask_answer;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTanant_id() {
        return tanant_id;
    }

    public void setTanant_id(String tanant_id) {
        this.tanant_id = tanant_id;
    }

    public String getAppend_ask_answer() {
        return append_ask_answer;
    }

    public void setAppend_ask_answer(String append_ask_answer) {
        this.append_ask_answer = append_ask_answer;
    }

    @Override
    public String toString() {
        return "IndexAnswerDetailsAppendAnswerParameter{" +
                "uid='" + uid + '\'' +
                ", tanant_id='" + tanant_id + '\'' +
                ", append_ask_answer='" + append_ask_answer + '\'' +
                '}';
    }
}
