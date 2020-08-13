package com.example.sqlspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CatController {

    private CatRepository repository;

    @Autowired
    public CatController(CatRepository repository){
        this.repository = repository;
    }

    @GetMapping("/create")
    public String createCat(@RequestParam(required = false)String name){
        if (name!= null){
            repository.save(new Cat(name));
        } else{
            repository.save(new Cat());
        }
        return "index";

    }
    @GetMapping("/list")
    @ResponseBody
    public Iterable<Cat> listCats(){
        return repository.findAll();
    }
    @GetMapping("/listbyid")
    @ResponseBody
    public Iterable<Cat> listById(@RequestParam Long id){
        return repository.findCatById(id);
    }
}
