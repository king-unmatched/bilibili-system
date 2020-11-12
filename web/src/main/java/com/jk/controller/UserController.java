package com.jk.controller;

import com.alibaba.fastjson.JSONArray;
import com.jk.entity.ComicvBean;
import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
import com.jk.entity.VideoBean;
import com.jk.pojo.PoiUtils;
import com.jk.service.UserService;
import com.jk.utils.Constants;
import com.jk.utils.FileUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("user")
public class UserController {
   @Resource
    private UserService userService;

    /**
     * 用户登录验证
     *
     * @param user
     * @return
     */
   @RequestMapping("seluser")
   public String seluser(UserBean user){
       Subject subject = SecurityUtils.getSubject();
       UsernamePasswordToken upt = new UsernamePasswordToken(user.getUsercode(), user.getPassword());
       try {
           // 不抛异常代表登录成功
           subject.login(upt);
           return "登录成功";
       } catch (UnknownAccountException uae) {
           return "账号不存在";
       } catch (IncorrectCredentialsException ice) {
           return "密码错误";
       } catch (AuthenticationException ae) {
           return "登录失败，网络错误";
       }

   }
    /**
     *  权限树
      */

   @RequestMapping("serTreeBeanList")
   public List<TreeBean> serTreeBeanList(){
      UserBean userBean= (UserBean) SecurityUtils.getSubject().getPrincipal();
      return userService.serTreeBeanList(userBean.getId());
   }

    /**
     * 电影信息查询
     *
     */

    @RequestMapping("selVideoBean")
    public List<VideoBean> selVideoBean(){

       return userService.selVideoBean();
    }

    /**
     * 动漫查询
     * @return
     */
    @RequestMapping("selcomicv")
    public List<ComicvBean> selcomicv(){
       return userService.selcomicv();
    }

    /**
     * 动漫信息导出
     * @param response
     */
    @RequestMapping("exsynthesize")
    @RequiresPermissions("exsy:moviedaochu")
    public void exsynthesize(HttpServletResponse response){
          List<ComicvBean> com=userService.selcomicv();
        String jsonString=JSONArray.toJSONString(com);
        JSONArray dataAraay=JSONArray.parseArray(jsonString);
        HashMap<String,String> map=new LinkedHashMap<>();
        map.put("动漫名称","name");
        map.put("浏览量","playback");
        PoiUtils.exportExcel(response, dataAraay, map, "动漫浏览信息", "动漫浏览表格.xlsx");
    }

    /**
     * 电影信息导出
     *
     * @param response
     */
    @RequestMapping("exdianying")
    @RequiresPermissions("exsy:anmiedaochu")
    public void exdianying(HttpServletResponse response){
       List<VideoBean> list=userService.selVideoBean();
       String jsonarray=JSONArray.toJSONString(list);
         JSONArray dataarray=  JSONArray.parseArray(jsonarray);
         HashMap<String,String> map=new LinkedHashMap<>();
         map.put("电影名称","videoName");
         map.put("浏览量","videoHeat");
         PoiUtils.exportExcel(response,dataarray,map,"电影浏览信息","电影浏览表格.xlsx");
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(req,resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            preview(req,resp);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public void preview(HttpServletRequest req,HttpServletResponse resp) throws ClassNotFoundException, IOException
    {
        String fpath=req.getParameter("fpath");
        if(fpath==null)
            return;
        String filename= Constants.HDFSAddress+fpath;
        Configuration config=new Configuration();
        FileSystem fs = null;
        FSDataInputStream in=null;
        try {
            fs = FileSystem.get(URI.create(filename),config);
            in=fs.open(new Path(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        final long fileLen = fs.getFileStatus(new Path(filename)).getLen();
        String range=req.getHeader("Range");
        resp.setHeader("Content-type","video/mp4");
        OutputStream out=resp.getOutputStream();
        if(range==null)
        {
            filename=fpath.substring(fpath.lastIndexOf("/")+1);
            resp.setHeader("Content-Disposition", "attachment; filename="+filename);
            resp.setContentType("application/octet-stream");
            resp.setContentLength((int)fileLen);
            IOUtils.copyBytes(in, out, fileLen, false);
        }
        else
        {
            long start=Integer.valueOf(range.substring(range.indexOf("=")+1, range.indexOf("-")));
            long count=fileLen-start;
            long end;
            if(range.endsWith("-"))
                end=fileLen-1;
            else
                end=Integer.valueOf(range.substring(range.indexOf("-")+1));
            String ContentRange="bytes "+String.valueOf(start)+"-"+end+"/"+String.valueOf(fileLen);
            resp.setStatus(206);
            resp.setContentType("video/mpeg4");
            resp.setHeader("Content-Range",ContentRange);
            in.seek(start);
            try{
                IOUtils.copyBytes(in, out, count, false);
            }
            catch(Exception e)
            {
                throw e;
            }
        }
        in.close();
        in = null;
        out.close();
        out = null;}

}
