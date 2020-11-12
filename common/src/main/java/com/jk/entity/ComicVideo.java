package com.jk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ComicVideo {
    private Integer id;

    private String name;

    private String comicXiaoimg;

    private String info;

    private Integer playback;

    private String img;

    private Integer type;

    private String url;

    private Integer comicNumber;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date toUpdate;

    private Integer jiNumber;

    private String comicTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getComicXiaoimg() {
        return comicXiaoimg;
    }

    public void setComicXiaoimg(String comicXiaoimg) {
        this.comicXiaoimg = comicXiaoimg == null ? null : comicXiaoimg.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getPlayback() {
        return playback;
    }

    public void setPlayback(Integer playback) {
        this.playback = playback;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getComicNumber() {
        return comicNumber;
    }

    public void setComicNumber(Integer comicNumber) {
        this.comicNumber = comicNumber;
    }

    public Date getToUpdate() {
        return toUpdate;
    }

    public void setToUpdate(Date toUpdate) {
        this.toUpdate = toUpdate;
    }

    public Integer getJiNumber() {
        return jiNumber;
    }

    public void setJiNumber(Integer jiNumber) {
        this.jiNumber = jiNumber;
    }

    public String getComicTitle() {
        return comicTitle;
    }

    public void setComicTitle(String comicTitle) {
        this.comicTitle = comicTitle == null ? null : comicTitle.trim();
    }
}