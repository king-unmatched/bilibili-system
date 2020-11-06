package com.jk.entity;

import lombok.Data;

@Data
public class UserBean {
    private Integer id;

    private String usercode;

    private String username;

    private String password;

    private String salt;

    private String locked;

    private Integer userLevel;

    private Integer userDiamond;




}