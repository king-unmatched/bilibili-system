package com.jk.controller;

import com.jk.entity.NewVideoBean;
import com.jk.service.NewVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewVideoController {
    @Autowired
    private NewVideoService newVideoService;

    @RequestMapping("inserNewVideo")
    public void inserNewVideo(@RequestBody NewVideoBean newVideoBean){
        newVideoService.inserNewVideo(newVideoBean);
    }
}
