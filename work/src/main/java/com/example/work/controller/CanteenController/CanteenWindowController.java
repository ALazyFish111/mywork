package com.example.work.controller.CanteenController;

import com.example.work.config.MyArrayList;
import com.example.work.entity.IdQuest;
import com.example.work.entity.mymenu.CanteenWindow;
import com.example.work.entity.mymenu.Dish;
import com.example.work.service.menu.CanteenWindowServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/canteen")
public class CanteenWindowController {
    @Autowired
    private CanteenWindowServlet canteenWindowServlet;



    @PostMapping("/showwindow")
    public List<CanteenWindow> showall(@RequestBody IdQuest idQuest){
        System.out.println(idQuest);
        System.out.println(idQuest.getCanteenId());
        return canteenWindowServlet.showall(idQuest.getCanteenId());
    }
}
