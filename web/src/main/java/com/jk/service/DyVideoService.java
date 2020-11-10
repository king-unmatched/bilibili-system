package com.jk.service;

import com.jk.entity.DysyVideo;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sys-provider")
public interface DyVideoService {
    @RequestMapping("listDy")
    public PageResult listDy(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody DysyVideo dys);

    @RequestMapping("addDys")
    public void addDys(@RequestBody DysyVideo dys);

    @RequestMapping("deleteD")
    public void deleteD(@RequestParam String id);

    @RequestMapping("huixian")
    public DysyVideo huixian(@RequestParam Integer id);
}
