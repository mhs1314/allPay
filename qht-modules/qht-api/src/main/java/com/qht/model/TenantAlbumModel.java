package com.qht.model;

import java.io.Serializable;

public class TenantAlbumModel implements Serializable {
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
        return "TenantAlbumModel{" +
                "uid='" + uid + '\'' +
                ", album='" + album + '\'' +
                ", index='" + index + '\'' +
                '}';
    }


}
