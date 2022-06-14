package com.example.kidsgov2.controllers;
import com.example.kidsgov2.entities.Persona;
import com.example.kidsgov2.models.services.IpersonaService;
import com.example.kidsgov2.models.services.IpersonaTipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
//Nos deja manejar el objeto
@SessionAttributes("persona")
public class PersonaController {
    @Autowired
    private IpersonaService ipersonaService;
    @Autowired
    private IpersonaTipoPersonaService ipersonaTipoPersonaService;

    @GetMapping("/listaPersonas")
    public String listaPersona(Model model) {
        model.addAttribute("titulo", "KidsGo");
        model.addAttribute("subtitulo", "Listado de personas");
        model.addAttribute("personas", ipersonaService.findAll());

        return "/listObject/listaPersonas";
    }



    //Obtenemos el get
    @GetMapping("/addPersona")
    public String agregarPersona(Model model) {
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("persona", new Persona());
        model.addAttribute("titulo", "Registro de usuario");
        return "/addObject/addPersona";
    }

    //Edit

    @RequestMapping(value = "/addPersona/{idPersona}")
    public String editarPersona(@PathVariable(value = "idPersona") Long id, Map<String,Object> model){
        model.put("persona",ipersonaService.findAll());

        Persona persona = null;
        if(id>0){
            persona = ipersonaService.findOne(id);
            if(persona == null){
                return "redirect:/listaPersonas";
            }
        }else {
            return "redirect:/listaPersonas";
        }

        model.put("persona",persona);
        model.put("titulo","Editar Persona");
        return "/addObject/addPersona";


    }
    //Post
    @PostMapping("/addPersona")
    public String crearPersona(@Validated Persona persona,Model model, BindingResult result, RedirectAttributes redirectAttributes, SessionStatus status) {
        if (result.hasErrors()) {
            return "/addObject/addPersona";
        }
        model.addAttribute("idPersona",persona.getIdPersona());
        persona.setEstado(true);
        ipersonaService.save(persona);
        status.setComplete();
        //return "redirect:/listaPersonas";
        return  "redirect:/register/"+persona.getIdPersona();
    }
    //Delete
    @RequestMapping("deletePersona/{id}")
    public String deleteRuta(@PathVariable(value = "id") Long id, RedirectAttributes flash){
        if (id > 0){
            ipersonaService.remove(id);
            flash.addFlashAttribute("succes","Ruta eliminadad con exito");
        }

        return "redirect:/listaPersonas";
    }


    //Eliminar con cambio de estado

    @RequestMapping(value = "deletePersonaId/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

        if (id > 0) {
            ipersonaService.deleteByPersonaId(id);
            flash.addFlashAttribute("success", "Persona eliminada con éxito");
        }
        return "redirect:/listaPersonas";
    }
}
