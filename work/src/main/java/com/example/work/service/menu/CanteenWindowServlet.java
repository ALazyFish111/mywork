package com.example.work.service.menu;

import com.example.work.config.MyArrayList;
import com.example.work.config.MyMaxHeap;
import com.example.work.entity.mymenu.Dish;
import com.example.work.mapper.CanteenWindowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CanteenWindowServlet {
    @Autowired
    private CanteenWindowMapper canteenWindowMapper;

    public List<Dish> findByid(int id){
        System.out.println(id);
        return canteenWindowMapper.selectAlldish(id);
    }
    public MyArrayList<Dish> greaterByid(int id){
        System.out.println(id);
        List<Dish> list = canteenWindowMapper.selectAlldish(id);
        MyMaxHeap myMaxHeap = new MyMaxHeap();
        for(int i = 0 ; i < list.size() ; i++){
//            System.out.println(list.get(i).toString());
            myMaxHeap.push(list.get(i));
        }
//        List<Dish> mylist = new ArrayList<>();

        MyArrayList<Dish> myArrayList = new MyArrayList<>();
        while (myMaxHeap.isEmpty() == false){
//            mylist.add(myMaxHeap.pop());
            myArrayList.add(myMaxHeap.pop());
        }
//        for (int i = 0 ; i < myArrayList.size() ; i++){
//            System.out.println(myArrayList.get(i).toString());
//        }
        return myArrayList;
    }
}
