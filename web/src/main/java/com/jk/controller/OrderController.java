package com.jk.controller;

import com.jk.entity.Ddorder;
import com.jk.pojo.PageResult;
import com.jk.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("selectOr")
    @ResponseBody
    public PageResult selectOr(Integer currPage, Integer pageSize, Ddorder dd){
        return orderService.listOr(currPage,pageSize,dd);
    }

    @RequestMapping("addOrder")
    @ResponseBody
    @RequiresPermissions("order:add")
    public void addOrder(Ddorder dd){
        orderService.addOr(dd);
    }

    @RequestMapping("deleteOrder")
    @ResponseBody
    @RequiresPermissions("order:delete")
    public void deleteOrder(String id){
        orderService.deleteOr(id);
    }

    @RequestMapping("huixianOrder")
    @ResponseBody
    @RequiresPermissions("order:update")
    public Ddorder huixianOrder(Integer id){
        return  orderService.huixianOr(id);
    }

    @RequestMapping("show")
    @RequiresPermissions("order:query")
    public String show(){
        return "order/show";
    }
}
