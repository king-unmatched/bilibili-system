package com.jk.service;

import com.jk.entity.Ddorder;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "sys-provider")
public interface OrderService {
    @RequestMapping("listOr")
    public PageResult listOr(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody Ddorder dd);

    @RequestMapping("addOr")
    public void addOr(@RequestBody Ddorder dd);

    @RequestMapping("deleteOr")
    public void deleteOr(@RequestParam String id);

    @RequestMapping("huixianOr")
    public Ddorder huixianOr(@RequestParam Integer id);
}
