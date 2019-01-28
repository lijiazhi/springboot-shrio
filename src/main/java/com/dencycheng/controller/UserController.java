package com.dencycheng.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @anthor DencyCheng
 * @date 2018/11/5 0005
 */
@Controller
public class UserController {

    @RequiresPermissions("user:add")
    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        return "有权限";
    }

    @RequestMapping("/401")
    public String noAuth(){
        return "401";
    }

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public String doLogin(String username,String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        subject.login(usernamePasswordToken);

        return "成功";
    }
}
