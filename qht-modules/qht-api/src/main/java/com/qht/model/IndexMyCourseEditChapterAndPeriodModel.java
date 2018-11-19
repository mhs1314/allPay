package com.qht.model;



import com.qht.dto.ChapterDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName IndexMyCourseEditChapterAndPeriodParameter
 * @Author Zuoxh
 * @Data 2018/11/19 0019 下午 6:48
 */
public class IndexMyCourseEditChapterAndPeriodModel implements Serializable {

    private String uid;

    private String pkg_name;

    private String content;

    private Date create_time;

    private String cover;

    private List<ChapterModel>  chapter;

    public List<ChapterModel> getChapter() {
        return chapter;
    }

    public void setChapter(List<ChapterModel> chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "IndexMyCourseEditChapterAndPeriodModel{" +
                "uid='" + uid + '\'' +
                ", pkg_name='" + pkg_name + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", cover='" + cover + '\'' +
                ", chapter=" + chapter +
                '}';
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

