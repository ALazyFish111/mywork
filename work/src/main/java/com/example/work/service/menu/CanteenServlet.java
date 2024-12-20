package com.example.work.service.menu;

import com.example.work.config.MyArrayList;
import com.example.work.entity.mymenu.CanteenWindow;
import com.example.work.mapper.CanteenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanteenServlet {
    @Autowired
    private CanteenMapper canteenMapper;

    public List<CanteenWindow> findByid(int id){
        System.out.println(id);
        List<CanteenWindow> list = canteenMapper.selectAllwindow(id);
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i).toString());
        }
        return list;
    }
}
