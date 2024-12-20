package com.example.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.work.config.MyArrayList;
import com.example.work.entity.mymenu.Canteen;
import com.example.work.entity.mymenu.CanteenWindow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CanteenMapper extends BaseMapper<Canteen> {

    @Select("SELECT cw.id AS id, " +
            "cw.name AS name, " +
            "cw.canteen_id AS canteenId " +
            "FROM CanteenWindow cw " +
            "JOIN Canteen c ON cw.canteen_id = c.id " +
            "WHERE cw.canteen_id = #{canteenId}")
    List<CanteenWindow> selectAllwindow(@Param("canteenId") int canteenid);
    //添加可以直接添加
    //删除也可以直接删除
    //修改也可以直接修改
}
