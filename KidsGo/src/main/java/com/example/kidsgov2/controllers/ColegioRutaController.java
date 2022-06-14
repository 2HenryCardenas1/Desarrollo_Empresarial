package com.example.kidsgov2.controllers;

import com.example.kidsgov2.entities.ColegioRuta;
import com.example.kidsgov2.entities.ViajeRuta;
import com.example.kidsgov2.models.services.IcolegioRutaService;
import com.example.kidsgov2.models.services.IrutaService;
import com.example.kidsgov2.models.services.IviajeRutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//Nos deja manejar el objeto
@SessionAttributes("colegio_ruta")
public class ColegioRutaController {
    @Autowired
    private IcolegioRutaService icolegioRutaService;
    @Autowired
    private IrutaService irutaService;

    @RequestMapping("/colegio/asignarRuta/{id}")
    public String agregar(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("titulo","Asigacion ruta");
        //llamamos la lista de los tipos de personas existentes
        model.addAttribute("id",id);
        model.addAttribute("colegioruta",irutaService.findAll());
        //Creamos un nuevo valor en nuestra tabla de rompimiento PERSONA-TIPOPERSONA
        model.addAttribute("colegioRuta",new ColegioRuta());
        return "/addObject/asignarRutaColegio";
    }

    @PostMapping("/colegio/asignarRuta")
    public String asignar(@Validated ColegioRuta colegioRuta, BindingResult result, Model model){
        if(result.hasErrors()){
            //Me rretorna al mismo template
            return "/addObject/asignarRutaColegio";
        }
        icolegioRutaService.save(colegioRuta);
        return "redirect:/listarColegios";
    }
}
