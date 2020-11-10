package com.jk.controller;

import com.jk.entity.VideoBean;
import com.jk.service.VideoService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;
    @RequestMapping("selVideoBean")
    public  List<VideoBean>  selVideoBean(){

        return videoService.selVideoBean();
    }
}
