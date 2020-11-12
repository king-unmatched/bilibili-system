package com.jk.controller;

import com.jk.entity.DysyVideo;
import com.jk.entity.NewVideo;
import com.jk.pojo.PageResult;
import com.jk.service.NewVideoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hot")
public class NewVideoController {
    @Autowired
    private NewVideoService newVideoService;

    @RequestMapping("selecthotVideo")
    @ResponseBody
    public PageResult selectVideo(Integer currPage, Integer pageSize, NewVideo hot){
        return newVideoService.selectHot(currPage,pageSize,hot);
    }
    @RequestMapping("addHotV")
    @ResponseBody
    @RequiresPermissions("hot:add")
    public void addHotV(NewVideo hot){
        newVideoService.addHot(hot);
    }

    @RequestMapping("show")
    @RequiresPermissions("hot:query")
    public String show(){
        return "hot/show";
    }

    @RequestMapping("delHotV")
    @ResponseBody
    @RequiresPermissions("hot:delete")
    public void delHotV(String id){
        newVideoService.delHot(id);
    }


    @RequestMapping("huiHotV")
    @ResponseBody
    @RequiresPermissions("hot:update")
    public NewVideo huiHotV(Integer id){
        return newVideoService.huiHot(id);
    }
}
