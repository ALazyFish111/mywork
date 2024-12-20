package com.example.work.controller.CanteenController;

import com.example.work.config.MyArrayList;
import com.example.work.entity.mymenu.Dish;
import com.example.work.service.menu.CanteenWindowServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/canteen")
public class CanteenWindowController {
    @Autowired
    private CanteenWindowServlet canteenWindowServlet;

    @RequestMapping("/finddishid/{id}")
    public List<Dish> find(@PathVariable int id){
        System.out.println(id);
        return canteenWindowServlet.findByid(id);
    }
    @RequestMapping("/dish_greater/{id}")
    public MyArrayList<Dish> dish_greater(@PathVariable int id){
//        System.out.println(id);
//        MyArrayList<Dish> myArrayList = canteenWindowServlet.greaterByid(id);
//        for (int i = 0 ; i < myArrayList.size() ; i++){
//            System.out.println(myArrayList.get(i).toString());
//        }
        return canteenWindowServlet.greaterByid(id);
    }
}
