package com.qht.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName IndexMyCourseEditChapterAndPeriodParameter
 * @Author Zuoxh
 * @Data 2018/11/19 0019 下午 6:48
 */
public class IndexMyCourseEditChapterAndPeriodDto implements Serializable {

    private String uid;

    private String pkg_name;

    private String content;

    private Date create_time;

    private String play_type_id;

    public String getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(String play_type_id) {
        this.play_type_id = play_type_id;
    }

    @Override
    public String toString() {
        return "IndexMyCourseEditChapterAndPeriodDto{" +
                "uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", play_type_id='" + play_type_id + '\'' +
                ", cover='" + cover + '\'' +
                ", chapters=" + chapters +
                '}';
    }

    private String cover;

    private List<ChapterDto>  chapters;

    public List<ChapterDto> getChapters() {
        return chapters;
    }

    public void setChapters(List<ChapterDto> chapters) {
        this.chapters = chapters;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }


}

