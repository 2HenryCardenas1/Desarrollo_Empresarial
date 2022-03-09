package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutaController {
    @Autowired
    private IrutaService irutaService;

    @GetMapping("/listaRutas")
    public String listarRutas(Model model) {
        model.addAttribute("titulo", "Listado de rutas");
        model.addAttribute("rutas", irutaService.findAll());

        return "listaRutas";
    }
}
