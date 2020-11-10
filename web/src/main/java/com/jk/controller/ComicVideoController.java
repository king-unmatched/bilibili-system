package com.jk.controller;

import com.jk.entity.ComicVideo;
import com.jk.pojo.PageResult;
import com.jk.service.ComicVideoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("comic")
public class ComicVideoController {
    @Autowired
    private ComicVideoService comicVideoService;

    @RequestMapping("selectCo")
    @ResponseBody
    public PageResult selectC(Integer currPage, Integer pageSize, ComicVideo comi){
        return comicVideoService.listCo(currPage,pageSize,comi);
    }
    @RequestMapping("show")
    @RequiresPermissions("comic:query")
    public String show(){
        return "comic/show";
    }


    @RequestMapping("addCo")
    @ResponseBody
    @RequiresPermissions("comic:add")
    public void addCo(ComicVideo comic){
        comicVideoService.addC(comic);
    }

    @RequestMapping("delCo")
    @ResponseBody
    @RequiresPermissions("comic:delete")
    public void delCo(String id){
        comicVideoService.delC(id);
    }


    @RequestMapping("huiCo")
    @ResponseBody
    @RequiresPermissions("comic:update")
    public ComicVideo huiCo(Integer id){
        return  comicVideoService.huiC(id);
    }

}

