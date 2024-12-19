package com.example.work.controller.UserController;

import com.example.work.entity.myuser.Users;
import com.example.work.service.RegisterServlet;
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
    public Map<String,Boolean> register_check(@RequestBody String username){
        System.out.println(username);
        boolean exists = registerServlet.register_check(username);
        Map<String,Boolean>response = new HashMap<String, Boolean>() ;
        response.put("exists",exists);
        return response;
    }
//    @PostMapping("/register_confirm")
//    public String register_confirm(@RequestBody Users users){
//        System.out.println(users.getUsername() + " " + users.getPassword());
//        boolean exists = registerServlet.insert(users);
//        Map<String,Boolean>response = new HashMap<String, Boolean>() ;
//        response.put("exists",exists);
//        return response;
//    }
}
