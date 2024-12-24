package com.example.work.controller.UserController;

import com.example.work.entity.myuser.Users;
import com.example.work.service.user.RegisterServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RegisterController {
    @Autowired
    private RegisterServlet registerServlet;

    @PostMapping("/register_check")
    public Map<String,Boolean> register_check(@RequestBody(required = false) Users users){
        System.out.println(users);
        boolean exists = registerServlet.register_check(users.getUsername());
        Map<String,Boolean>response = new HashMap<String, Boolean>() ;
        response.put("exists",exists);
        System.out.println(exists);
        return response;
    }
    @PostMapping("/register_add")
    public String register_add(@RequestBody Users users){
        System.out.println(users);
//        System.out.println(users.getUsername() + " " + users.getPassword());
        String reslut = registerServlet.add(users);
        System.out.println(reslut);
        return reslut;
    }
}
