package com.example.kidsgo.controllers;

import com.example.kidsgo.entities.Colegio;
import com.example.kidsgo.models.services.IcolegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    //Obtenemos el get
    @GetMapping("/addColegios")
    public String agregarColegio(Model model){
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("colegio",new Colegio());
        model.addAttribute("titulo","Agragar Colegio");
        //Me manda al crearColegios
        return "addColegios";
    }

    //Post

    @PostMapping("/addColegios")
    public String crearColegios(@Validated Colegio colegio, BindingResult result, Model model){
    if(result.hasErrors()){
        return  "addColegios";
    }
    icolegioService.save(colegio);
    //guardamos
    return "redirect:/listarColegios";
    }
}
