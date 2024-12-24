package com.example.work.controller.CanteenController;

import com.example.work.config.MyArrayList;
import com.example.work.entity.mymenu.Canteen;
import com.example.work.entity.mymenu.CanteenWindow;
import com.example.work.service.menu.CanteenServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/canteen")
public class CanteenController {
    @Autowired
    private CanteenServlet canteenServlet;
    @RequestMapping("/findwindowsid/{id}")
    public List<CanteenWindow> find(@PathVariable int id){
        System.out.println(id);
        List<CanteenWindow> myArrayList = canteenServlet.findByid(id);

        return myArrayList;
    }

    @PostMapping("/allcanteen")
    public List<Canteen> allcanteen(){
        List<Canteen> myArrayList = canteenServlet.all();
        System.out.println(myArrayList.toString());

        return myArrayList;
    }


    @RequestMapping("/test")
    public String test(){
        return "1111";
    }
}
