package com.example.work.controller;

import com.example.work.entity.myuser.Users;
import com.example.work.service.LoginServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TestController {
    @Autowired
    private LoginServlet loginServlet;
    @RequestMapping("/test")
    public String login(@RequestBody Users formData){
        System.out.println(formData.getUsername() + " " + formData.getPassword());
//        loginServlet.login(formData.getUsername(),formData.getPassword());
        return "false";
    }

}
