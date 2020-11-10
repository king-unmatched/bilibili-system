
package com.jk.utils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public class FileUtil {

	public static String uploadFile(MultipartFile imgfile,HttpServletRequest request){
    	//1、上传路径：项目发布tomcat服务器
		//D:\workUtilsInstall\apache-tomcat-8.0.0\webapps\week_employee_hzy\\upload
		String path = request.getServletContext().getRealPath("/")+"/upload";
		
		//2、文件
		File file = new File(path);
		if(!file.exists()){//不存在
			file.mkdirs();
		}
		
		//生成新的文件名称，原因：防止文件名称一样后者上传的文件会覆盖前者上传的文件（前提是文件名称必须一样并且在用一个目录下）
		//生成新的文件名称，保证文件名称唯一有两种方法：
		// 	  1.通过UUID实现文件名称唯一 （UUID会生成32位字母+数字唯一的一个字符串）
		//	  2.通过时间戳现文件名称唯一  （时间戳是毫秒级时间 时间会一直往上加，生成13位数字）注意只有java生成13位 其他则是10位比如oracle、mysql、php
		//  获取时间戳
		//long currentTimeMillis = System.currentTimeMillis();
		//System.out.println(currentTimeMillis);
		String uuid = UUID.randomUUID().toString();
		
		String oldName = imgfile.getOriginalFilename();//1.jpg
		//截取文件后缀:.jpg
		String suffix = oldName.substring(oldName.lastIndexOf("."));
		//新文件名
		String newFile = uuid+suffix;
		
		//3、上传
		////D:\workUtilsInstall\apache-tomcat-8.0.0\webapps\week_employee_hzy\\upload\1.jpg
		File file2 = new File(path+"\\"+newFile);
		try {
			imgfile.transferTo(file2);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile;		
	}

		public static ResponseEntity<byte[]> downloadFile(String filename,HttpServletRequest request){

		//1、获取要下载的文件:文件的完整地址
		//D:\workUtilsInstall\apache-tomcat-8.0.0\webapps\ssm-demo-wdd\\upload\\1.jpg
		String path = request.getServletContext().getRealPath("/")+"/upload/"+filename;
		
		//2、把下载的文件转换成字节数组
		File file = new File(path);
		byte[] byteArray = null;
		HttpHeaders header = new HttpHeaders();
		try {
			byteArray = FileUtils.readFileToByteArray(file);
			//3、设置响应为文件下载：header设置
			//name :设置 content-disposition 属性的值  inline
			//filename:下载显示的文件名称
			header.setContentDispositionFormData("attchment", URLEncoder.encode(filename, "utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//4、下载：把文件输出/返回到浏览器
		//参数一  body:下载的文件内容
		//参数二 headers: 设置响应为文件下载
		//参数参 请求的状态码  200 404 400 500
		return new ResponseEntity<byte[]>(byteArray, header, HttpStatus.OK);		
	}
	
	
	
	
}
