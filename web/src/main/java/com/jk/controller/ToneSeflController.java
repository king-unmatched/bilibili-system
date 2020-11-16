package com.jk.controller;

import com.jk.entity.ToneSelfBean;
import com.jk.service.ToneSeflService;
import com.jk.utils.AliyunOSSUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("tone")
public class ToneSeflController {
    @Autowired
    private ToneSeflService toneSeflService;



    @RequestMapping("selToneSelf")
    public List<ToneSelfBean> selToneSelf(){
        List<ToneSelfBean> list= toneSeflService.selToneSelfBean();
        System.out.println(list);
        return list ;
    }
    @RequestMapping("upstatus")
    @RequiresPermissions("tone:uptones")
    public void upstatus(Integer ids){
        toneSeflService.upstatus(ids);
    }

}
