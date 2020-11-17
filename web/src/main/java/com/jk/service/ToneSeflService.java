package com.jk.service;

import com.jk.entity.ToneSelfBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "sys-provider")
public interface ToneSeflService {



    @RequestMapping("selToneSelfBean")
    public List<ToneSelfBean> selToneSelfBean();


    @RequestMapping("upstatus")
    public void upstatus(@RequestParam Integer ids);
}
