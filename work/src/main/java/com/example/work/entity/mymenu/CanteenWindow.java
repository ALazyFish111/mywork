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
@TableName("canteenwindow")
public class CanteenWindow {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer canteenId;
    private String name;
}
