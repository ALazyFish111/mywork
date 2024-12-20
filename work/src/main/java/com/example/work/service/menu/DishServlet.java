package com.example.work.service.menu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.work.entity.mymenu.Dish;
import com.example.work.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DishServlet {
    @Autowired
    private DishMapper dishMapper;

    public Dish findbyid(int id,int windowid,int carteenid){
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        map.put("window_Id",windowid);
        map.put("carteen_Id",carteenid);
        queryWrapper.allEq(map);
        Dish dish = dishMapper.selectOne(queryWrapper);
        System.out.println(dish.toString());
        return dish;
    }
}
