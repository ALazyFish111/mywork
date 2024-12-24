package com.example.work.service.menu;

import com.example.work.entity.mymenu.Canteen;
import com.example.work.entity.mymenu.CanteenWindow;
import com.example.work.mapper.Canteen.CanteenMapper;
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
    public List<Canteen> all(){
        List<Canteen> list = canteenMapper.selectList(null);
        return  list;
    }
}
