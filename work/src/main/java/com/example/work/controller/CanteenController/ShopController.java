package com.example.work.controller.CanteenController;

import com.example.work.config.MyLinkedList;
import com.example.work.entity.mymenu.Dish;
import com.example.work.service.menu.DishServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/canteen")
public class ShopController {
//    @Autowired
//    private DishServlet dishServlet;
//    private MyLinkedList<Dish> myLinkedList = new MyLinkedList<>();
//    @RequestMapping("/shop/{id}/{windowid}/{canteenid}")
//    public String shop(@PathVariable int id,@PathVariable int windowid,@PathVariable int canteenid){
//        Dish dish = dishServlet.findbyid(id,windowid,canteenid);
//        myLinkedList.addLast(dish);
//        System.out.println(myLinkedList.toString());
//        return "成功添加";
//    }

//    public String show(){
//        return {idx,dish信息}
//    }
//    public String delete(){
//        通过前端传idx
//    }
}
