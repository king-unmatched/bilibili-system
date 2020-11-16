package com.jk.controller;

import com.jk.entity.ToneSelfBean;
import com.jk.service.ToneSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToneSelfController {
    @Autowired
    private ToneSelfService toneSelfService;


    @RequestMapping("selToneSelfBean")
    public List<ToneSelfBean> selToneSelfBean(){
        return toneSelfService.selToneSelfBean();
    }

    @RequestMapping("upstatus")

    public void upstatus(@RequestParam Integer ids){
        toneSelfService.upstatus(ids);
    }
}
