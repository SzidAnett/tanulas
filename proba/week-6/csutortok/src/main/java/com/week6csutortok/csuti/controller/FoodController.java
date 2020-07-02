package com.week6csutortok.csuti.controller;

import com.week6csutortok.csuti.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class FoodController {

    List<Food> foods = new ArrayList<>(Arrays.asList(
            new Food("Sunny side egg", 350),
            new Food("Lecso", 401),
            new Food("Langos", 500)
    ));

    @GetMapping("/")
    public String index(Model model){ //a Model model-t itt hívom meg
        Food food = new Food("Pizza", 500);
        model.addAttribute("food", food);//a html egy food modelt vár, itt adom meg neki, az elsővel!
        model.addAttribute("foods", foods);
        model.addAttribute("totalAmount", getTotalCalories());
        return "index";
    }
    @PostMapping("/save-food")  //PostMapping, mert ez egy post kérés lesz
    public String saveFood(@ModelAttribute Food food){    //itt azt mondom, h egy Food típusú dolgot szeretnék kapni,
         foods.add(food);  //hozzáadom a foods listához  //ha kap egy name, amount adatot, akkor ő kreál belőle nekünk egy Foodot
        return "redirect:/"; //lefuttatja az index()-ben lévő dolgokat, mert szüksége van azokra az adatokra is
        //public String saveFood(String name, Integer amount){ Ez ugyanaz, csak kevésbé elegáns, de ehhez kell a html-ben egy name attributum
    }
        //debugging a terminalban: piros pötty a foods.add mellé
        //rányomni a bogárkára, böngészőben hozzáadni egy új értéket
        //megjelenik a terminálban, hogy mit adtam hozzá

    @GetMapping("/edit-food/{foodId}") //érkezni fog egy foodId változó, amit megkap a path-en keresztül értékül az Integer
    public String editFood(@PathVariable Integer foodId, Model model){
        Optional<Food> optionalFood = findFood(foodId);  //mi van akkor, ha nincs ilyen Id-val food, akkor le kell kezelni
        if(optionalFood.isPresent()){                   //ez a jó eset, ha van
            Food food = optionalFood.get();         //kiszedem ezt a Food-ot, a get-el
            model.addAttribute("food", food);         //kell egy model, mert szeretnék adatot küldeni a viewnak
            return "editFood";
        }
        return "redirect:/";                            //ha nincs, akkor menj a főoldalra és kezd újra
    }

    @GetMapping("/edit-food")
    public String editFood2(@RequestParam Integer foodId, Model model){
        Optional<Food> optionalFood = findFood(foodId);
        if(optionalFood.isPresent()){
            Food food = optionalFood.get();
            model.addAttribute("food", food);
            return "editFood";
        }
        return "redirect:/";


    }
    @PostMapping("/update-food")
    public String updateFood(@RequestParam Integer foodId, @ModelAttribute Food food) {
        Optional<Food> optionalOldFood = findFood(foodId);  //nézzük meg, hogy tényleg van e ilyen régi food

        if (optionalOldFood.isPresent()) {                    //ha van
            Food oldFood = optionalOldFood.get();           //kiszedem ezt a Food-ot, a get-el

            oldFood.setName(food.getName());                //akkor tudom updatelni a nevét
            oldFood.setAmount(food.getAmount());            //és tudom updatelni a mennyiségét
        }
        return "redirect:/";                                //vissza a főoldalra és ha minden oké, akkor már az updatelt kajákat fogjuk látni
    }


    private Integer getTotalCalories(){
        return foods.stream()
                .mapToInt(f -> f.getAmount()) //.mapToInt(Food::getAmount) ez ugyanaz!
                .sum();
    }
    private Optional<Food> findFood(Integer foodId){  //opcional food, mert nem tudom, h létezik  e ott egyáltalán food ilyen Id-val
        return foods.stream()
                .filter(f -> f.getId().equals(foodId))
                .findFirst();
    }
}

//debugging a böngészőben: devtools -> Network -> beírod az értéket

//edit-food/43 -> path variable
//edit-food?foodId=43 -> request param