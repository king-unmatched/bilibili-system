package com.jk.utils;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;

//配置阿里云的OSS文件上传的
public class AliyunOSSUtil {

    private static String endpoint = "https://oss-cn-beijing.aliyuncs.com";

    private static String accessKeyId = "LTAI4GH8sLztJSYzxN7MRn8A";

    private static String accessKeySecret = "sccMg8uV2nq1aieHfVFMPwDcee05Kk";

    private static String bucketName = "diwuzu123";


    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        if (FilenameExtension.equalsIgnoreCase(".mp4")||FilenameExtension.equalsIgnoreCase(".3gp")||FilenameExtension.equalsIgnoreCase(".webm")) {
            return "video/mp4";
        }
        return "image/jpg";
    }

    public static String uploadFile(String objectKey, MultipartFile multipartFile)
            throws OSSException, ClientException, FileNotFoundException {
        /*   System.out.println("是否进入了uploadFile方法");*/
        // 1.创建OSSClient的实例
        OSS ossClient  = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        //StringBuffer sb = new StringBuffer();
        // 上传的文件不是空，并且文件的名字不是空字符串
        if (multipartFile.getSize() != 0 && !"".equals(multipartFile.getName())) {
            ObjectMetadata om = new ObjectMetadata();
            //设置OSS后台输入地址可以直接访问，而不是下载
            om.setContentType(getcontentType(objectKey.substring(objectKey.lastIndexOf("."))));
            om.setContentLength(multipartFile.getSize());
            // 设置文件上传到服务器的名称
            om.addUserMetadata("filename", objectKey);
            try {
                ossClient.putObject(bucketName, "img/"+objectKey, new ByteArrayInputStream(multipartFile.getBytes()), om);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 设置这个文件地址的有效时间
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        URL url = ossClient.generatePresignedUrl(bucketName, "img/"+objectKey, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }






}