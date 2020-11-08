package com.jk.controller;


import com.jk.utils.FileUtil;
import com.jk.utils.HdfsClientUtil;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("file")
public class FileController {

    @Test
    public void upload(){

        // 输入流 java io流
        FileInputStream inputStream = null;
        // HDFS输出流
        FSDataOutputStream fsOutputStream = null;

        try{
            String newFileName = "/home";

            String file = "E:\\学习笔记加作业\\实训二\\1104hudoop\\2020-11-4 hadoop.mp4";
            // 获取后缀名点的下标
            int lastIndex = file.lastIndexOf(".");
            // 根据最后一个. 截取到最后， 后缀名 .html  .png
            String suffix = file.substring(lastIndex);
            String imgArr = ".jpg,.png,.jpeg,.gif";
            String video = ".mp4,.avi,.rmvb";

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


            if(imgArr.contains(suffix)){
                newFileName += "/img";
            } else if(video.contains(suffix)) {
                newFileName += "/video";
            } else {
                newFileName += "/file";
            }



            newFileName += "/" + sdf.format(date) + "/" + System.currentTimeMillis()+suffix;
            // jpg,png,jpeg,gif

            // mp4,avi,rmvb

            // file文件路径为上传后的路径地址

            File newFile = new File(file);
            inputStream = new FileInputStream(newFile);

            fsOutputStream = HdfsClientUtil.getFileSystem().create(new Path(newFileName));

            IOUtils.copyBytes(inputStream, fsOutputStream, 4096, false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(inputStream);
            IOUtils.closeStream(fsOutputStream);
        }

    }
}
