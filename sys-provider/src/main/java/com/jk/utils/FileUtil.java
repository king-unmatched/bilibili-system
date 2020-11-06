package com.jk.utils;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    /**
     * 上传文件
     * @param file 文件对象
     * @param module 模块名称
     * @return
     */
    public static String upload(MultipartFile file, String module) {
        // 输入流 java io流
        InputStream inputStream = null;
        // HDFS输出流
        FSDataOutputStream fsOutputStream = null;

        String newFileName = "/" + module;

        try {

            String fileUrl = file.getOriginalFilename();
            // 获取后缀名点的下标
            int lastIndex = fileUrl.lastIndexOf(".");
            // 根据最后一个. 截取到最后， 后缀名 .html  .png
            String suffix = fileUrl.substring(lastIndex);

            String imgArr = ".jpg,.png,.jpeg,.gif";
            String video = ".mp4,.avi,.rmvb";

            if (imgArr.contains(suffix)) {
                newFileName += "/img";
            } else if (video.contains(suffix)) {
                newFileName += "/video";
            } else {
                newFileName += "/file";
            }

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            newFileName += "/" + sdf.format(date) + "/" + System.currentTimeMillis() + suffix;
            // jpg,png,jpeg,gif

            // mp4,avi,rmvb

            // file文件路径为上传后的路径地址

            inputStream = file.getInputStream();

            fsOutputStream = HdfsClientUtil.getFileSystem().create(new Path(newFileName));

            IOUtils.copyBytes(inputStream, fsOutputStream, 4096, false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(inputStream);
            IOUtils.closeStream(fsOutputStream);
        }

        return newFileName;

    }

    /**
     * 下载文件
     * @param fileUrl 文件路径
     */
    public static void download(String fileUrl) {
        // 定义hadoop输入流
        FSDataInputStream fsInputStream =  null;
        try {

            fsInputStream = HdfsClientUtil.getFileSystem().open(new Path(fileUrl));

            IOUtils.copyBytes(fsInputStream, System.out, 4096, false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(fsInputStream);
        }
    }

}
