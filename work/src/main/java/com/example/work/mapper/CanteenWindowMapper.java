package com.example.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.work.entity.mymenu.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CanteenWindowMapper extends BaseMapper<Dish> {
    @Select("SELECT d.id, d.name, d.price, d.taste, d.window_id, d.carteen_id " +
            "FROM dish d " +
            "JOIN canteenwindow cw ON d.window_id = cw.id " +
            "WHERE cw.id = #{windowId}")
    List<Dish> selectAlldish(@Param("windowId") int windowid);
}
