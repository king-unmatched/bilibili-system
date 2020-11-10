package com.jk.controller;


import com.jk.entity.LogBean;
import com.jk.pojo.PageResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("log")
public class LogBeanController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("listLog")
    @ResponseBody
    public PageResult listLog(Integer currPage, Integer pageSize, LogBean mo){
        Query query=new Query();
        long count = mongoTemplate.count(query, LogBean.class);
        int start=(currPage-1)*pageSize;
        query.skip(start).limit(pageSize);
        List<LogBean> list=mongoTemplate.find(query,LogBean.class);
        Long totalPage = count%pageSize == 0 ? count/pageSize : (count/pageSize + 1);
        return new PageResult(count,list,currPage,pageSize,totalPage);
    }

    @RequestMapping("show")
    @RequiresPermissions("log:show")
    public String show(){
        return "log/log";
    }

}
