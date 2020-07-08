package com.dispring.dispring.service;

import com.dispring.dispring.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ItemService {
    public List<Item> getList(){
        return Arrays.asList(new Item("table"), new Item("car"));
    }

}
