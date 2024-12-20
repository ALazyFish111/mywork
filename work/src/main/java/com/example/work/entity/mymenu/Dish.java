package com.example.work.entity.mymenu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.work.config.MyArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private double price;
    private String taste;
    private Integer windowId;
    private Integer carteenId;
}
