package com.qht.model;

import javax.sql.rowset.serial.SerialBlob;
import java.io.Serializable;

public class MyIndexCourseAnswerModel implements Serializable {

    public String getAnswer_file_name() {
        return answer_file_name;
    }

    public void setAnswer_file_name(String answer_file_name) {
        this.answer_file_name = answer_file_name;
    }

    public String getAnswer_time() {
        return answer_time;
    }

    public void setAnswer_time(String answer_time) {
        this.answer_time = answer_time;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getVideo_file() {
        return video_file;
    }

    public void setVideo_file(String video_file) {
        this.video_file = video_file;
    }

    public String getAnswer_file_url() {
        return answer_file_url;
    }

    public void setAnswer_file_url(String answer_file_url) {
        this.answer_file_url = answer_file_url;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getTeacher_nickname() {
        return teacher_nickname;
    }

    public void setTeacher_nickname(String teacher_nickname) {
        this.teacher_nickname = teacher_nickname;
    }

    @Override
    public String toString() {
        return "MyIndexCourseAnswerDto{" +
                "answer_file_name='" + answer_file_name + '\'' +
                ", answer_time='" + answer_time + '\'' +
                ", file_url='" + file_url + '\'' +
                ", question='" + question + '\'' +
                ", file_name='" + file_name + '\'' +
                ", chapter_name='" + chapter_name + '\'' +
                ", video_file='" + video_file + '\'' +
                ", answer_file_url='" + answer_file_url + '\'' +
                ", head='" + head + '\'' +
                ", uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", answer='" + answer + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", begin='" + begin + '\'' +
                ", teacher_nickname='" + teacher_nickname + '\'' +
                '}';
    }

    private String answer_file_name;

    private String answer_time;
    private String file_url;
    private String question;
    private String file_name;
    private String chapter_name;
    private String video_file;
    private String answer_file_url;
    private String head;
    private String uid;
    private String pkg_name;
    private String answer;
    private String nickname;
    private String name;
    private String begin;
    private String teacher_nickname;




}
