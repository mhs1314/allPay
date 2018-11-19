package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName PeriodDto
 * @Author Zuoxh
 * @Data 2018/11/19 0019 下午 6:52
 */
public class PeriodDto implements Serializable {

   private String period_name;

   private String period_id;

   private String video_file;

   private Date begin;

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(String period_id) {
        this.period_id = period_id;
    }

    public String getVideo_file() {
        return video_file;
    }

    public void setVideo_file(String video_file) {
        this.video_file = video_file;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    @Override
    public String toString() {
        return "PeriodDto{" +
                "period_name='" + period_name + '\'' +
                ", period_id='" + period_id + '\'' +
                ", video_file='" + video_file + '\'' +
                ", begin=" + begin +
                '}';
    }
}
