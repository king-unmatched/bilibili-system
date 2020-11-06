package com.jk.controller;






import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
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
}
