package com.jk.controller;






import com.alibaba.fastjson.JSONArray;
import com.jk.entity.ComicvBean;
import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
import com.jk.entity.VideoBean;
import com.jk.pojo.PoiUtils;
import com.jk.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("user")
public class UserController {
   @Autowired
    private UserService userService;
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
@RequestMapping("serTreeBeanList")
   public List<TreeBean> serTreeBeanList(){
      UserBean userBean= (UserBean) SecurityUtils.getSubject().getPrincipal();
      return userService.serTreeBeanList(userBean.getId());
   }


    @RequestMapping("selVideoBean")
    public List<VideoBean> selVideoBean(){

       return userService.selVideoBean();
    }
    @RequestMapping("selcomicv")
    public List<ComicvBean> selcomicv(){
       return userService.selcomicv();
    }

    /**
     * 动漫信息导出
     * @param response
     */
    @RequestMapping("exsynthesize")
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
    public void exdianying(HttpServletResponse response){
       List<VideoBean> list=userService.selVideoBean();
       String jsonarray=JSONArray.toJSONString(list);
         JSONArray dataarray=  JSONArray.parseArray(jsonarray);
         HashMap<String,String> map=new LinkedHashMap<>();
         map.put("电影名称","videoName");
         map.put("浏览量","videoHeat");
         PoiUtils.exportExcel(response,dataarray,map,"电影浏览信息","电影浏览表格.xlsx");
    }

}
