package com.example.work.controller.CanteenController;

import com.example.work.entity.IdQuest;
import com.example.work.entity.PriceRange;
import com.example.work.entity.mymenu.Dish;
import com.example.work.service.menu.DishServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/canteen")
public class DishController {
    @Autowired
    private DishServlet dishServlet;

    @PostMapping("/showdish")
    public List<Dish> showall(@RequestBody IdQuest idQuest){
        System.out.println(idQuest);
        return dishServlet.showall(idQuest.getWindowId(),idQuest.getCanteenId());

    }

    @PostMapping("/descshowdish")
    public List<Dish> descshowall(@RequestBody IdQuest idQuest){
        System.out.println(idQuest);
        return dishServlet.descshowall(idQuest.getWindowId(),idQuest.getCanteenId());
    }

    @PostMapping("/findbylikename")
    public List<Dish> findbylikename(@RequestBody String likename){
        System.out.println(likename);
        return dishServlet.findbylikename(likename);
    }
    @PostMapping("/invertPrice")
    public List<Dish> invertPrice(@RequestBody PriceRange priceRange){
        System.out.println(priceRange);
        return dishServlet.invertPrice(priceRange.getMin(),priceRange.getMax());
    }

    @PostMapping("/adddish")
    public String adddish(@RequestBody Dish dish){
        return dishServlet.add(dish);
    }
    @PostMapping("/show")
    public List<Dish> show(){
        return dishServlet.show();
    }
    @PostMapping("/delete")
    public List<Dish> delete(@RequestBody Integer id){
        return dishServlet.delete(id);
    }
}
