package com.jk.controller;

import com.jk.entity.Ddorder;
import com.jk.entity.DysyVideo;
import com.jk.pojo.PageResult;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("listOr")
    public PageResult listOr(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody Ddorder dd){
        return orderService.listOr(currPage,pageSize,dd);
    }

    @RequestMapping("addOr")
    public void addOr(@RequestBody Ddorder dd){
        orderService.addOr(dd);
    }

    @RequestMapping("deleteOr")
    public void deleteOr(@RequestParam String id){
        orderService.deleteOr(id);
    }
    @RequestMapping("huixianOr")
    public Ddorder huixianOr(@RequestParam Integer id){
        return  orderService.huixianOr(id);
    }
}
