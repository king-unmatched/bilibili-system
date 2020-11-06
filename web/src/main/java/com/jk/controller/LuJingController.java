package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/page")
public class LuJingController {
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("toindex")
    public String toindex()
    {
        return "tree/index";
    }
}
