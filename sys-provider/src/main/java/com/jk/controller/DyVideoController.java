package com.jk.controller;

import com.jk.entity.DysyVideo;
import com.jk.pojo.PageResult;
import com.jk.service.DyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DyVideoController {
    @Autowired
    private DyVideoService dyVideoService;

    @RequestMapping("listDy")
    public PageResult listDy(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody DysyVideo dys){
       return dyVideoService.listDy(currPage,pageSize,dys);
    }

    @RequestMapping("addDys")
    public void addDys(@RequestBody DysyVideo dys){
        dyVideoService.addDys(dys);
    }

    @RequestMapping("deleteD")
    public void deleteD(@RequestParam String id){
        dyVideoService.deleteD(id);
    }
    @RequestMapping("huixian")
    public DysyVideo huixian(@RequestParam Integer id){
      return  dyVideoService.huixian(id);
    }
}
