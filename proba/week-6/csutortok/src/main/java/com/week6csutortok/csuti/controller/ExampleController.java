package com.week6csutortok.csuti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RestController ha ezt hagynám itt, akkor az example szót írná ki a böngészőbe, a html tartalma helyett
public class ExampleController {

    @GetMapping("/sanyika")
    //@ResponseBody ha kiírnám, akkor ugyanaz lenne, mint a RestController, akkor használom, h vegyesen van nyers adat kiírása és html
    public String helloSanyi(Model model){
        model.addAttribute("name","zsigacska");
        return "example"; //ha elírom a html nevét vagy rossz helyen van, akkor error "template"
    }
}
