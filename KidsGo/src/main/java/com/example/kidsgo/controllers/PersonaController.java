package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IpersonaService;
import com.example.kidsgo.models.services.IpersonaTipoPersonaService;
import com.example.kidsgo.models.services.ItipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonaController {
    @Autowired
    private IpersonaService ipersonaService;


    @GetMapping("/listaPersonas")
    public String listaPersona(Model model){
        model.addAttribute("titulo","Listado de personas");
        model.addAttribute("personas",ipersonaService.findAll());

        return "listaPersonas";
    }
}
