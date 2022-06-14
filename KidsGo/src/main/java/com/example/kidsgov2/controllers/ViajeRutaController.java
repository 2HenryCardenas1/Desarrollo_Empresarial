package com.example.kidsgov2.controllers;

import com.example.kidsgov2.entities.PersonaTipoPersona;
import com.example.kidsgov2.entities.ViajeRuta;
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
@SessionAttributes("viaje_ruta")
public class ViajeRutaController {
    @Autowired
    private IviajeRutaService iviajeRutaService;
    @Autowired
    private IrutaService irutaService;

    @RequestMapping("/viaje/asignarRuta/{id}")
    public String agregar(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("titulo","Asigacion ruta");
        //llamamos la lista de los tipos de personas existentes
        model.addAttribute("id",id);
        model.addAttribute("viajeruta",irutaService.findAll());
        //Creamos un nuevo valor en nuestra tabla de rompimiento
        model.addAttribute("viajeRuta",new ViajeRuta());
        return "/addObject/asignarRuta";
    }

    @PostMapping("/viaje/asignarRuta")
    public String asignar(@Validated ViajeRuta viajeruta, BindingResult result, Model model){
        if(result.hasErrors()){
            //Me rretorna al mismo template
            return "/addObject/asignarRuta";
        }
        iviajeRutaService.save(viajeruta);
        return "redirect:/listarViajes";
    }


}
