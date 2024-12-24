package com.example.work;

import com.example.work.config.MyArrayList;
import com.example.work.config.MyLinkedList;
import com.example.work.entity.mymenu.Dish;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

@SpringBootTest
class WorkApplicationTests {
    @Test
    void test1(){
        MyMaxHeap myMaxHeap = new MyMaxHeap();
        for (int i = 1 ; i <= 10 ; i++){
            Dish dish = new Dish(i,"一号饭堂" + i,i * 1.0 + 5,"难吃",1,1);
//            System.out.println(dish.getId());
            myMaxHeap.push(dish);
        }
        while (myMaxHeap.isEmpty() == false){
            Dish tmp = myMaxHeap.pop();
            System.out.println(tmp.getPrice() + " "+tmp.getName() + " " + tmp.getId());
        }
    }

    @Test
    void test2(){
        MyLinkedList<Integer>myLinkedList = new MyLinkedList<>();
        for(int i = 1 ; i <= 10 ; i++){
            myLinkedList.addLast(i);
        }
    }
    @Autowired
    private DishServlet111 dishServlet111;
    @Test
    void test3(){
        List<Dish>list = dishServlet111.findbylikename("辣椒");
    }

    void test4(){

    }
}
