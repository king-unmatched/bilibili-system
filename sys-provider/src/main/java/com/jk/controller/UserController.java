package com.jk.controller;

import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("selectUserInfoByCode")
    public UserBean selectUserInfoByCode(@RequestParam String userCode){
        return userService.seluser(userCode);
    }


    @RequestMapping("serTreeBeanList")
    public List<TreeBean> serTreeBeanList(@RequestParam Integer userId){
        return userService.serTreeBeanList(userId);
    }

    @RequestMapping("selprincipList")
    public List<String> selprincipList(@RequestParam Integer id){
        return userService.selprincipList(id);
    }
}
