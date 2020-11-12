package com.jk.entity;

public class NewVideo {
    private Integer newHotId;

    private String newHotName;

    private String newHotDuration;

    private Integer newHeat;

    private String newHotImg;

    private String newHotUrl;

    public Integer getNewHotId() {
        return newHotId;
    }

    public void setNewHotId(Integer newHotId) {
        this.newHotId = newHotId;
    }

    public String getNewHotName() {
        return newHotName;
    }

    public void setNewHotName(String newHotName) {
        this.newHotName = newHotName == null ? null : newHotName.trim();
    }

    public String getNewHotDuration() {
        return newHotDuration;
    }

    public void setNewHotDuration(String newHotDuration) {
        this.newHotDuration = newHotDuration == null ? null : newHotDuration.trim();
    }

    public Integer getNewHeat() {
        return newHeat;
    }

    public void setNewHeat(Integer newHeat) {
        this.newHeat = newHeat;
    }

    public String getNewHotImg() {
        return newHotImg;
    }

    public void setNewHotImg(String newHotImg) {
        this.newHotImg = newHotImg == null ? null : newHotImg.trim();
    }

    public String getNewHotUrl() {
        return newHotUrl;
    }

    public void setNewHotUrl(String newHotUrl) {
        this.newHotUrl = newHotUrl == null ? null : newHotUrl.trim();
    }
}