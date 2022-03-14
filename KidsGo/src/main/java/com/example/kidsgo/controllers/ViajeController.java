package com.example.kidsgo.controllers;

import com.example.kidsgo.entities.Colegio;
import com.example.kidsgo.entities.Viaje;
import com.example.kidsgo.models.services.IviajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViajeController {
    @Autowired
    private IviajeService iviajeService;

    //Viajes
    @GetMapping("/listarViajes")
    //El model llama los atributos que se quiera
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de viajes");
        model.addAttribute("viajes", iviajeService.findAll());
        return "listarViajes";
    }


    //Obtenemos el get
    @GetMapping("/addViaje")
    public String agregarViaje(Model model){
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("viaje",new Viaje());
        model.addAttribute("titulo","Agragar Viaje");
        //Me manda al crearColegios
        return "addViaje";
    }

    //Post

    @PostMapping("/addViaje")
    public String crearViaje(@Validated Viaje viaje, BindingResult result, Model model){
        if(result.hasErrors()){
            return  "addViaje";
        }
        iviajeService.save(viaje);
        //guardamos
        return "redirect:/listarViajes";
    }
}
