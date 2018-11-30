package com.qht.model;

import com.qht.dto.PeriodDto;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ChapterDto
 * @Author Zuoxh
 * @Data 2018/11/19 0019 下午 6:54
 */
public class ChapterModel implements Serializable {
    private String chapter_id;

    private String chapter_name;

    private List<PeriodModel> period;

    public List<PeriodModel> getPeriod() {
        return period;
    }

    public void setPeriod(List<PeriodModel> period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "ChapterModel{" +
                "chapter_id='" + chapter_id + '\'' +
                ", chapter_name='" + chapter_name + '\'' +
                ", period=" + period +
                '}';
    }

    public String getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(String chapter_id) {
        this.chapter_id = chapter_id;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

}
