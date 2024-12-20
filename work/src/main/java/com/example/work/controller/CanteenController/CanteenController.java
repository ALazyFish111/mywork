package com.example.work.controller.CanteenController;

import com.example.work.config.MyArrayList;
import com.example.work.entity.mymenu.CanteenWindow;
import com.example.work.service.menu.CanteenServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/canteen")
@CrossOrigin(origins = "*")
public class CanteenController {
    @Autowired
    private CanteenServlet canteenServlet;
    @RequestMapping("/findwindowsid/{id}")
    public List<CanteenWindow> find(@PathVariable int id){
        System.out.println(id);
        List<CanteenWindow> myArrayList = canteenServlet.findByid(id);

        return myArrayList;
    }


    @RequestMapping("/test")
    public String test(){
        return "1111";
    }
}
