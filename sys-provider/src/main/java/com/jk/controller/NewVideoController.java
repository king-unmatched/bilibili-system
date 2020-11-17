package com.jk.controller;

import com.jk.entity.NewVideo;
import com.jk.pojo.PageResult;
import com.jk.entity.NewVideoBean;
import com.jk.service.NewVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewVideoController {
    @Autowired
    private NewVideoService newVideoService;

    @RequestMapping("selectHot")
    public PageResult selectHot(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody NewVideo hot) {
        return newVideoService.selectHot(currPage, pageSize, hot);
    }

    @RequestMapping("addHot")
    public void addHot(@RequestBody NewVideo hot) {
        newVideoService.addHot(hot);
    }

    @RequestMapping("delHot")
    public void delHot(@RequestParam String id) {
        newVideoService.delHot(id);
    }


    @RequestMapping("huiHot")
    public NewVideo huiHot(@RequestParam Integer id) {
        return newVideoService.huiHot(id);
    }
        @RequestMapping("inserNewVideo")
        public void inserNewVideo (@RequestBody NewVideoBean newVideoBean){
            newVideoService.inserNewVideo(newVideoBean);
        }
    }

