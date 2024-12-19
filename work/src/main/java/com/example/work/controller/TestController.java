package com.example.work.controller;

import com.example.work.entity.myuser.Users;
import com.example.work.service.LoginServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TestController {
    @Autowired
    private LoginServlet loginServlet;
    @PostMapping("/test")
    public String test(@RequestBody Users user){
        System.out.println(user.getUsername() +" " + user.getPassword());
        System.out.println(user);
        return "111";
    }
}
