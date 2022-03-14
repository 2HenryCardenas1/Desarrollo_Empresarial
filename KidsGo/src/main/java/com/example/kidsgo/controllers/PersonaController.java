package com.example.kidsgo.controllers;

import com.example.kidsgo.entities.Colegio;
import com.example.kidsgo.entities.Persona;
import com.example.kidsgo.models.services.IpersonaService;
import com.example.kidsgo.models.services.IpersonaTipoPersonaService;
import com.example.kidsgo.models.services.ItipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonaController {
    @Autowired
    private IpersonaService ipersonaService;
    private ItipoPersonaService itipoPersonaService;
    private IpersonaTipoPersonaService ipersonaTipoPersonaService;

    @GetMapping("/listaPersonas")
    public String listaPersona(Model model) {
        model.addAttribute("titulo", "Listado de personas");
        model.addAttribute("personas", ipersonaService.findAll());
       // model.addAttribute("tipoPersona",ipersonaTipoPersonaService.listarTipoPersona());
        //Traemos el tipo de persona
        //model.addAttribute("personatipoPersona", ipersonaTipoPersonaService.findAll());

        return "listaPersonas";
    }


    //Obtenemos el get
    @GetMapping("/addPersona")
    public String agregarPersona(Model model) {
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("persona", new Persona());
        model.addAttribute("titulo", "Agragar Persona");
        return "addPersona";
    }

    //Post

    @PostMapping("/addPersona")
    public String crearPersona(@Validated Persona persona, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addPersona";
        }
        ipersonaService.save(persona);
        //guardamos
        return "redirect:/listaPersonas";
    }
}
