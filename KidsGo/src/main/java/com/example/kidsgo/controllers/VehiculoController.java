package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IvehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehiculoController {
    @Autowired
    private IvehiculoService ivehiculoService;

    @GetMapping("/listadoVehiculos")
    public String listaVehiculos(Model model){
        model.addAttribute("titulo","Listado de Vehculos");
        model.addAttribute("vehiculos",ivehiculoService.findAll());
        return "listadoVehiculos";
    }
}
