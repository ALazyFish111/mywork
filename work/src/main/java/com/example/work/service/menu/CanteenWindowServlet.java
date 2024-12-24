package com.example.work.service.menu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.work.entity.mymenu.CanteenWindow;
import com.example.work.mapper.Canteen.CanteenWindowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CanteenWindowServlet {
    @Autowired
    private CanteenWindowMapper canteenWindowMapper;


    public List<CanteenWindow> showall(int id){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        Map<String,Integer>map = new HashMap<>();
        map.put("canteen_id",id);
        queryWrapper.allEq(map);
        return canteenWindowMapper.selectList(queryWrapper);
    }

}
