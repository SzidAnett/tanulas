package com.dispring.dispring.controller;

import com.dispring.dispring.model.Item;
import com.dispring.dispring.service.ItemService;
import com.dispring.dispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ItemController {

    public ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService, UserService userService){
        System.out.println(userService);
        this.itemService = itemService;
    }

    //public ItemController(ItemService itemService) {
        //this.itemService = itemService;
    //}

    @GetMapping("/items")
    public String getItems(Model model) {

        model.addAttribute("items", itemService.getList());     //key: amit a html vár, value: amit a lista ad, amit meghívok az itemService-el
        return "items";
    }

    @GetMapping("/items2")
    public String getItems2(Model model) {
       
        model.addAttribute("items", itemService.getList());
        return"items";
    }
    
}
