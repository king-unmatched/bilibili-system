package com.jk.service;

import com.jk.entity.JxChoiceness;
import com.jk.pojo.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "sys-provider")
public interface jxcChoicenessService {

    @RequestMapping("selectJx")
    public PageResult selectJx(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody JxChoiceness jx);

    @RequestMapping("addJx")
    public void addJx(@RequestBody JxChoiceness comic);

    @RequestMapping("delJx")
    public void delJx(@RequestParam String id);

    @RequestMapping("huiJx")
    public JxChoiceness huiJx(@RequestParam Integer id);
}
