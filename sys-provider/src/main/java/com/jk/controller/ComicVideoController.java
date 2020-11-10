package com.jk.controller;

import com.jk.entity.ComicVideo;
import com.jk.pojo.PageResult;
import com.jk.service.ComicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicVideoController {
    @Autowired
    private ComicVideoService comicVideoService;

    @RequestMapping("listCo")
    public PageResult listCo(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody ComicVideo comi){
        return comicVideoService.listCo(currPage,pageSize,comi);
    }


    @RequestMapping("addC")
    public void addC(@RequestBody ComicVideo comic){
        comicVideoService.addC(comic);
    }

    @RequestMapping("delC")
    public void delC(@RequestParam String id){
        comicVideoService.delC(id);
    }


    @RequestMapping("huiC")
    public ComicVideo huiC(@RequestParam Integer id){
      return   comicVideoService.huiC(id);
    }

}
