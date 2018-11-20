package com.qht.dto;

import java.io.Serializable;

public class TenantAlbumDto implements Serializable {
    private String uid;

    private String album;

    private Integer index;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "TenantAlbumDto{" +
                "uid='" + uid + '\'' +
                ", album='" + album + '\'' +
                ", index='" + index + '\'' +
                '}';
    }


}
