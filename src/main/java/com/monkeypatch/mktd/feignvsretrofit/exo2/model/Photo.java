package com.monkeypatch.mktd.feignvsretrofit.exo2.model;

public class Photo {

    private String monkeyId;
    private String contentType;
    private long size;

    public String getMonkeyId() {
        return monkeyId;
    }

    public void setMonkeyId(String monkeyId) {
        this.monkeyId = monkeyId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
