package com.jk.service;

import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;

import java.util.List;

public interface UserService {

    UserBean seluser(String userCode);

    List<TreeBean> serTreeBeanList(Integer userId);

    List<String> selprincipList(Integer id);
}
