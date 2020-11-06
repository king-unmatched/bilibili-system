package com.jk.controller;


import com.jk.utils.FileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    @RequestMapping("fileTest")
    public void fileTest(MultipartFile file){
         /*= "E:\\app\\ES\\压缩包\\elasticsearch-6.5.4.zip";*/
        FileUtil.upload(file,"user");
    }
}
