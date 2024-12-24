//package com.example.work.controller;
//
//import com.example.work.config.MyArrayList;
//import com.example.work.entity.mymenu.Dish;
//import com.example.work.service.menu.CanteenWindowServlet;
//import com.example.work.service.menu.DishServlet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class TestServlet {
//    @Autowired
//    private DishServlet dishServlet;
////    @Autowired
//    private MyArrayList<Dish> myArrayList = new MyArrayList<>();
//    @PostMapping("/test")
//    public String test01(@RequestBody int id){
//        return  "1111";
//    }
//
//    @RequestMapping("/test02/{id}/{windowID}/{canteenId}")
//    public String test02(@PathVariable int id,@PathVariable int windowID,@PathVariable int canteenId){
//        System.out.println(id+ " " + windowID + " " + canteenId);
//        Dish dis = dishServlet.findbyid(id,windowID,canteenId);
////
//        myArrayList.add(dis);
//        System.out.println(myArrayList.toString());
//        return  "12312312222";
//    }
//}
