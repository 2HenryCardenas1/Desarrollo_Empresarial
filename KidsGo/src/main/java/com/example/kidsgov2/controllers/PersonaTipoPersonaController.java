package com.example.kidsgov2.controllers;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import com.example.kidsgov2.models.services.IpersonaTipoPersonaService;
import com.example.kidsgov2.models.services.ItipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PersonaTipoPersonaController {

    @Autowired
    private IpersonaTipoPersonaService ipersonaTipoPersonaService;
    @Autowired
    private ItipoPersonaService itipoPersonaService;


    //Preguntar como tomar el id de la persona creada recientemente para asignarle el tipo persona


    @RequestMapping("/asignarTipoPersona/{id}")
    public String agregar(@PathVariable(value = "id") Long id,Model model){
        model.addAttribute("titulo","Asigacion tipo persona");
        //llamamos la lista de los tipos de personas existentes
        model.addAttribute("id",id);
        model.addAttribute("tipopersona",itipoPersonaService.findAll());
        //Creamos un nuevo valor en nuestra tabla de rompimiento PERSONA-TIPOPERSONA
        model.addAttribute("personaTipoersona",new PersonaTipoPersona());
        return "/addObject/asignarTipoPersona";
    }

    @PostMapping("/asignarTipoPersona")
    public String asignar(@Validated PersonaTipoPersona tipoPersona, BindingResult result, Model model){
        if(result.hasErrors()){
            //Me rretorna al mismo template
            return "/addObject/asignarTipoPersona";
        }
        ipersonaTipoPersonaService.save(tipoPersona);
        return "redirect:/listaPersonas";
    }

    //Detales de la persona

    @RequestMapping("/details/typePersonDetail/{idPersona}")
    public String detallesPersona(@PathVariable(value = "idPersona") Long id, Map<String,Object> model){
        model.put("titulo","Detalles de la persona");
        model.put("tipopersonasearch",ipersonaTipoPersonaService.findByIdTipoPersona(id));
        return "/details/typePersonDetail";
    }
}
