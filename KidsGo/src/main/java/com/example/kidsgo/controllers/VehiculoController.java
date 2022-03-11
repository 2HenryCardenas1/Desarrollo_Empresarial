package com.example.kidsgo.controllers;

import com.example.kidsgo.entities.Vehiculo;
import com.example.kidsgo.models.services.IvehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/addVehiculo")
    public String agregarVehiculo(Model model){
        model.addAttribute("titulo","Agregar Vehiculo");
        model.addAttribute("vehiculo",new Vehiculo());

        return "addVehiculo";
    }

    @PostMapping("/addVehiculo")
    public String crearVehiculo(@Validated Vehiculo vehiculo, BindingResult result, Model model){
        if(result.hasErrors()){
            return "addVehiculo";
        }
        ivehiculoService.save(vehiculo);
        return "redirect:/listadoVehiculos";
    }

}
