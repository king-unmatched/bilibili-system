package com.jk.service;

import com.jk.entity.NewVideo;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sys-provider")
public interface NewVideoService {
    @RequestMapping("selectHot")
    public PageResult selectHot(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody NewVideo hot);

    @RequestMapping("addHot")
    public void addHot(@RequestBody NewVideo hot);

    @RequestMapping("delHot")
    public void delHot(@RequestParam String id);

    @RequestMapping("huiHot")
    public NewVideo huiHot(@RequestParam Integer id);
}
