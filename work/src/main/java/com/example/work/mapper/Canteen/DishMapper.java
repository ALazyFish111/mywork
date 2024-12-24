package com.example.work.mapper.Canteen;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.work.entity.mymenu.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {

    @Select("SELECT id, name, price, taste, window_id, carteen_id " +
            "FROM dish " +
            "WHERE name LIKE '%${name}%' ")
    List<Dish> findByNameLike(@Param("name") String name);
}
