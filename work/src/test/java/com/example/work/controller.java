package com.example.work;

import com.example.work.entity.mymenu.Dish;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/test1")
public class controller {

    @PostMapping("/01")
    public MyLinkedList<Dish> test01(){
        MyLinkedList<Dish> myLinkedList = new MyLinkedList<>();
        for(int i = 1 ; i <= 10 ; i++){
            Dish dish = new Dish(i,"test" + i,i * 10 + 1.0,"no",1,1);
            myLinkedList.addLast(dish);
        }
        return myLinkedList;
    }
}
