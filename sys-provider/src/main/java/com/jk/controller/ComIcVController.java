package com.jk.controller;

import com.jk.entity.ComicvBean;
import com.jk.service.ComicvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComIcVController {
    @Autowired
    private ComicvService comicvService;
    @RequestMapping("selcomicv")
    public List<ComicvBean> selcomicv(){
        return comicvService.sekcomicv();
    }
}
