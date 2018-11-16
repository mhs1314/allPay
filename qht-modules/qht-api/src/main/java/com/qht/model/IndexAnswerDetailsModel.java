package com.qht.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class IndexAnswerDetailsModel implements Serializable {
    private Date answer_time;
    private String teacher_name;
    private String question;
    private String school_name;
    private String period_name;
    private String answer_file_url;
    private Integer type;
    private String append_ask_answer;
    private String cover;
    private String head;
    private String uid;
    private String pkg_name;
    private String student_name;
    private String question_url;
    private String answer;
    private String append_ask;
    private String subject_name;
    private BigDecimal is_exceptional;
    private String teacher_subject_name;
    private Date time;
    private String back_img;
    private Integer praise_number;

    public Date getAnswer_time() {
        return answer_time;
    }

    public void setAnswer_time(Date answer_time) {
        this.answer_time = answer_time;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getAnswer_file_url() {
        return answer_file_url;
    }

    public void setAnswer_file_url(String answer_file_url) {
        this.answer_file_url = answer_file_url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAppend_ask_answer() {
        return append_ask_answer;
    }

    public void setAppend_ask_answer(String append_ask_answer) {
        this.append_ask_answer = append_ask_answer;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPkg_name() {
        return pkg_name;
    }

    public void setPkg_name(String pkg_name) {
        this.pkg_name = pkg_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getQuestion_url() {
        return question_url;
    }

    public void setQuestion_url(String question_url) {
        this.question_url = question_url;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAppend_ask() {
        return append_ask;
    }

    public void setAppend_ask(String append_ask) {
        this.append_ask = append_ask;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public BigDecimal getIs_exceptional() {
        return is_exceptional;
    }

    public void setIs_exceptional(BigDecimal is_exceptional) {
        this.is_exceptional = is_exceptional;
    }

    public String getTeacher_subject_name() {
        return teacher_subject_name;
    }

    public void setTeacher_subject_name(String teacher_subject_name) {
        this.teacher_subject_name = teacher_subject_name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getBack_img() {
        return back_img;
    }

    public void setBack_img(String back_img) {
        this.back_img = back_img;
    }

    public Integer getPraise_number() {
        return praise_number;
    }

    public void setPraise_number(Integer praise_number) {
        this.praise_number = praise_number;
    }

    @Override
    public String toString() {
        return "IndexAnswerDetailsDto{" +
                "answer_time=" + answer_time +
                ", teacher_name='" + teacher_name + '\'' +
                ", question='" + question + '\'' +
                ", school_name='" + school_name + '\'' +
                ", period_name='" + period_name + '\'' +
                ", answer_file_url='" + answer_file_url + '\'' +
                ", type=" + type +
                ", append_ask_answer='" + append_ask_answer + '\'' +
                ", cover='" + cover + '\'' +
                ", head='" + head + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", student_name='" + student_name + '\'' +
                ", question_url='" + question_url + '\'' +
                ", answer='" + answer + '\'' +
                ", append_ask='" + append_ask + '\'' +
                ", subject_name='" + subject_name + '\'' +
                ", is_exceptional=" + is_exceptional +
                ", teacher_subject_name='" + teacher_subject_name + '\'' +
                ", time=" + time +
                ", back_img='" + back_img + '\'' +
                ", praise_number=" + praise_number +
                '}';
    }
}
