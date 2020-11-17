package com.jk.controller;

import com.jk.entity.JxChoiceness;
import com.jk.pojo.PageResult;
import com.jk.service.jxcChoicenessService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("choi")
public class JxChoicenessController {
   @Autowired
    private jxcChoicenessService jxcChoicenessService;

    @RequestMapping("selectJxC")
    @ResponseBody
    public PageResult selectJxC(Integer currPage,Integer pageSize,JxChoiceness jx){
        return jxcChoicenessService.selectJx(currPage,pageSize,jx);
    }

    @RequestMapping("addJxC")
    @ResponseBody
    @RequiresPermissions("choi:add")
    public void addJxC(JxChoiceness jx){
        jxcChoicenessService.addJx(jx);
    }

    @RequestMapping("delJxC")
    @ResponseBody
    @RequiresPermissions("choi:delete")
    public void delJxC(String id){
        jxcChoicenessService.delJx(id);
    }


    @RequestMapping("huiJxC")
    @ResponseBody
    @RequiresPermissions("choi:update")
    public JxChoiceness huiJxC(Integer id){
        return   jxcChoicenessService.huiJx(id);
    }

    @RequestMapping("show")
    @RequiresPermissions("choi:query")
    public String show(){
        return  "choi/show";
    }
}
