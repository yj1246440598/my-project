package com.enjoy.controller;

//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

//    @PostMapping("/toLogin")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(usernamePasswordToken);
//            return "main";
//        } catch (AuthenticationException e) {
//            String msg = "用户或密码错误";
//            if (!StringUtils.isEmpty(e.getMessage())) {
//                msg = e.getMessage();
//            }
//            return "login";
//        }
//    }
}
