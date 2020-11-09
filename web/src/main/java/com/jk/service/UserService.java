package com.jk.service;

import com.jk.entity.ComicvBean;
import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
import com.jk.entity.VideoBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "sys-provider")
public interface UserService {
    @RequestMapping("selectUserInfoByCode")
    public UserBean selectUserInfoByCode(@RequestParam String userCode);



    @RequestMapping("serTreeBeanList")
   public List<TreeBean> serTreeBeanList(@RequestParam Integer userId);


    @RequestMapping("selprincipList")
    public List<String> selprincipList(@RequestParam Integer id);


    @RequestMapping("selVideoBean")

    public  List<VideoBean>  selVideoBean();


    @RequestMapping("selcomicv")
    public List<ComicvBean> selcomicv();
}
