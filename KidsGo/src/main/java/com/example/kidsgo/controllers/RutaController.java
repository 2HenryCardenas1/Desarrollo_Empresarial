package com.example.kidsgo.controllers;

import com.example.kidsgo.entities.Ruta;
import com.example.kidsgo.models.services.IcolegioService;
import com.example.kidsgo.models.services.IrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ResourceBundle;

@Controller
public class RutaController {
    @Autowired
    private IrutaService irutaService;
    private IcolegioService icolegioService;

    @GetMapping("/listaRutas")
    public String listarRutas(Model model) {
        model.addAttribute("titulo", "Listado de rutas");
        model.addAttribute("rutas", irutaService.findAll());

        return "listaRutas";
    }

    @GetMapping("/addRuta")
    public String agregarRuta(Model model){
        model.addAttribute("titulo","Agregar Ruta");
        model.addAttribute("ruta",new Ruta());
       // model.addAttribute("colegios", icolegioService.findAll());
        return "addRuta";
    }

    @PostMapping("/addRuta")
    public String crearRuta(@Validated Ruta ruta, BindingResult result, Model model){
        if (result.hasErrors()){
            return "addRuta";
        }
        irutaService.save(ruta);
        return "redirect:/listaRutas";
    }
}
