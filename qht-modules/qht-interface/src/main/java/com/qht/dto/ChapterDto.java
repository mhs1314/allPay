package com.qht.dto;

import com.qht.dto.PeriodDto;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName ChapterDto
 * @Author Zuoxh
 * @Data 2018/11/19 0019 下午 6:54
 */
public class ChapterDto implements Serializable {
    private String chapter_id;

    private String chapter_name;

    private List<PeriodDto> periods;

    public List<PeriodDto> getPeriods() {
        return periods;
    }

    public void setPeriods(List<PeriodDto> periods) {
        this.periods = periods;
    }

    @Override
    public String toString() {
        return "ChapterDto{" +
                "chapter_id='" + chapter_id + '\'' +
                ", chapter_name='" + chapter_name + '\'' +
                ", periods=" + periods +
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
