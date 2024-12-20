package com.example.work.controller.UserController;

import com.example.work.config.MyArrayList;
import com.example.work.entity.mymenu.Dish;
import com.example.work.entity.myuser.Users;
import com.example.work.service.user.LoginServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private LoginServlet loginServlet;
    @PostMapping("/login_check")
    public Map<String,Boolean> login_check(@RequestBody Users user){
        System.out.println(user.getUsername() +" " + user.getPassword());
        System.out.println(user);
        boolean exists = loginServlet.login(user.getUsername(), user.getPassword());
        Map<String,Boolean>response = new HashMap<String, Boolean>() ;
        response.put("exists",exists);
        System.out.println(exists);
        return response;
    }

}
