package com.example.kidsgov2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping("/")
    //El model llama los atributos que se quiera
    public String main(Model model) {
        model.addAttribute("titulo", "KidsGo");
        return "index.html";
    }


}
