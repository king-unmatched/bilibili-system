package com.jk.controller;

import com.jk.entity.DysyVideo;
import com.jk.pojo.PageResult;
import com.jk.service.DyVideoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("video")
public class DyVideoController {
    @Autowired
    private DyVideoService dyVideoService;

    @RequestMapping("selectVideo")
    @ResponseBody
    public PageResult selectVideo(Integer currPage, Integer pageSize, DysyVideo dys){
        return dyVideoService.listDy(currPage,pageSize,dys);
    }
    @RequestMapping("addVideo")
    @ResponseBody
    @RequiresPermissions("video:add")
    public void addVideo(DysyVideo dys){
        dyVideoService.addDys(dys);
    }

    @RequestMapping("show")
    @RequiresPermissions("video:query")
     public String show(){
        return "video/show";
    }

    @RequestMapping("deleteVideo")
    @ResponseBody
    @RequiresPermissions("video:delete")
    public void deleteVideo(String id){
        dyVideoService.deleteD(id);
    }


    @RequestMapping("huixianVideo")
    @ResponseBody
    @RequiresPermissions("video:update")
    public DysyVideo huixianVideo(Integer id){
       return dyVideoService.huixian(id);
    }

}
