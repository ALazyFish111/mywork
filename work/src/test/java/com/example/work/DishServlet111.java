package com.example.work;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.work.config.MyMaxHeap;
import com.example.work.entity.mymenu.Dish;
import com.example.work.mapper.Canteen.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DishServlet111 {
    @Autowired
    private DishMapper dishMapper;

    public List<Dish> showall(int windowid, int carteenid){
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("window_Id",windowid);
        map.put("carteen_Id",carteenid);
        queryWrapper.allEq(map);
        List<Dish> myArrayList = dishMapper.selectList(queryWrapper);
        System.out.println(myArrayList.toString());
        return myArrayList;
    }

    public List<Dish> descshowall(int windowid, int carteenid){
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("window_Id",windowid);
        map.put("carteen_Id",carteenid);
        queryWrapper.allEq(map);
        List<Dish> list = dishMapper.selectList(queryWrapper);
        MyMaxHeap myMaxHeap = new MyMaxHeap();
        for(int i = 0 ; i < list.size() ; i++){
//            System.out.println(list.get(i).toString());
            myMaxHeap.push(list.get(i));
        }
//        List<Dish> mylist = new ArrayList<>();
        List<Dish> list1 = new ArrayList<>();
        while (myMaxHeap.isEmpty() == false){
//            mylist.add(myMaxHeap.pop());
            list1.add(myMaxHeap.pop());
        }
//        for (int i = 0 ; i < myArrayList.size() ; i++){
//            System.out.println(myArrayList.get(i).toString());
//        }
        System.out.println(list1.toString());
        return list1;
    }

    public List<Dish> findbylikename(String likename){
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name",likename);
//        List<Dish>myArrayList = dishMapper.selectList(queryWrapper);
        List<Dish> myArrayList = dishMapper.findByNameLike(likename);
        System.out.println(myArrayList.toString());
        return myArrayList;
    }



}
