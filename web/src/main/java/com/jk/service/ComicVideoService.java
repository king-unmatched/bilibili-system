package com.jk.service;

import com.jk.entity.ComicVideo;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sys-provider")
public interface ComicVideoService {

    @RequestMapping("listCo")
    public PageResult listCo(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody ComicVideo comi);

    @RequestMapping("addC")
    public void addC(@RequestBody ComicVideo comic);

    @RequestMapping("delC")
    public void delC(@RequestParam String id);

    @RequestMapping("huiC")
    public ComicVideo huiC(@RequestParam Integer id);
}
