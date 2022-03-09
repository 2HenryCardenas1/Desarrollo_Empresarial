package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IcolegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ColegioController {
    @Autowired
    private IcolegioService icolegioService;


    //Ruta
    @GetMapping("/listarColegios")
    //El model llama los atributos que se quiera
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Colegios");
        model.addAttribute("colegios", icolegioService.findAll());
        return "listarColegios";
    }
}
