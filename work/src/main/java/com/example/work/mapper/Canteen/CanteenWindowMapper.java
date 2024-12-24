package com.example.work.mapper.Canteen;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.work.entity.mymenu.CanteenWindow;
import com.example.work.entity.mymenu.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CanteenWindowMapper extends BaseMapper<CanteenWindow> {

}
