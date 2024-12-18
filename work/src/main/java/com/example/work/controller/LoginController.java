package com.example.work.controller;

import com.example.work.service.LoginServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    private LoginServlet loginServlet;
    @RequestMapping("/login/{username}/{password}/")
    public String login(@PathVariable String username,
                        @PathVariable String password){
        if(loginServlet.login(username,password)){
            return "登录成功";
        }else{
            return "账号或密码有误";
        }
    }
//    @RequestMapping("/login")
//    public String login(){
//        return "1111";
//    }
}
