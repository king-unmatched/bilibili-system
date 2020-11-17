package com.jk.controller;

import com.jk.entity.JxChoiceness;
import com.jk.pojo.PageResult;
import com.jk.service.JxChoicenessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JxChoicenessController {
    @Autowired
    private JxChoicenessService jxChoicenessService;

    @RequestMapping("selectJx")
    public PageResult selectJx(@RequestParam Integer currPage, @RequestParam Integer pageSize, @RequestBody JxChoiceness jx){
        return jxChoicenessService.selectJx(currPage,pageSize,jx);
    }

    @RequestMapping("addJx")
    public void addJx(@RequestBody JxChoiceness jx){
        jxChoicenessService.addJx(jx);
    }

    @RequestMapping("delJx")
    public void delJx(@RequestParam String id){
        jxChoicenessService.delJx(id);
    }


    @RequestMapping("huiJx")
    public JxChoiceness huiJx(@RequestParam Integer id){
        return   jxChoicenessService.huiJx(id);
    }
}
