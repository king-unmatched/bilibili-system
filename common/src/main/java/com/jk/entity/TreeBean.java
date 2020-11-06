package com.jk.entity;

import lombok.Data;

import java.util.List;

@Data
public class TreeBean {
    private Integer id;
    private String text;
    private String href;
    private Boolean selectable;
    private Integer pid;
    private List<TreeBean> nodes;
    private Boolean leaf;
}
