package com.jk.service.impl;

import com.jk.entity.ComicvBean;
import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
import com.jk.entity.VideoBean;
import com.jk.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    public String show(){
        return "网络异常，请稍后再试";
    }
    @Override
    public UserBean selectUserInfoByCode(String userCode) {
        return null;
    }

    @Override
    public List<TreeBean> serTreeBeanList(Integer userId) {
        return null;
    }

    @Override
    public List<String> selprincipList(Integer id) {
        return null;
    }

    @Override
    public List<VideoBean> selVideoBean() {
        return null;
    }

    @Override
    public List<ComicvBean> selcomicv() {
        return null;
    }
}
