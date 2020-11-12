package com.jk.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClientUtil {
    /*
        封装工具的特性
            1、经常连接服务器的代码
            2、相同的代码经常被使用
            3、封装的代码中公共的数据必须是私有 静态 常量 最终的
            4、定义公共方法必须是静态方法指定参数以及返回值
            5、提取方法中如果有异常，一定try / catch 捕捉异常
    */
	// HDFS文件系统操作客户端对象
    private static Configuration config = null;
	// HDFS相关所以配置信息，通过FileSystem文件系统来加载配置信息
    private static FileSystem fs = null;
	// 设置HDFS操作的机器地址和端口号
    private static final String HDFS_URL = "hdfs://192.168.2.34:9000";
	// 设置操作HDFS的用户
    private static final String HDFS_USER = "root";

    public static FileSystem getFileSystem(){

        try {
			//获取配置参数configuration对象，此对象会对xxx-site.xml文件进行解析
            config = new Configuration();

            ////设置操作的服务器地址
            config.set("fs.defaultFS", HDFS_URL);

            //文件操作系统对象
            //产生的实例究竟是哪一个文件系统的客户端，是根据conf相关参数来决定的
            fs = FileSystem.get(new URI(HDFS_URL), config, HDFS_USER);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return fs;
    }

}
