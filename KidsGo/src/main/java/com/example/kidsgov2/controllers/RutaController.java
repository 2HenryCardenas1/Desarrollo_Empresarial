package com.example.kidsgov2.controllers;

import com.example.kidsgov2.entities.Ruta;
import com.example.kidsgov2.models.services.IrutaService;
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
@SessionAttributes("ruta")
public class RutaController {
    @Autowired
    private IrutaService irutaService;


    @GetMapping("/listaRutas")
    public String listarRutas(Model model) {
        model.addAttribute("titulo", "Listado de rutas");
        model.addAttribute("rutas", irutaService.findAll());
        //model.addAttribute("colegioDestino", icolegioRutaService.findAll());

        return "/listObject/listaRutas";
    }

    //Crear

    @GetMapping("/addRuta")
    public String agregarRuta(Model model) {
        model.addAttribute("titulo", "Agregar Ruta");
        model.addAttribute("ruta", new Ruta());
        // model.addAttribute("colegios", icolegioService.findAll());
        return "/addObject/addRuta";
    }


    //Edit

    @RequestMapping(value = "/addRuta/{idRuta}")
    public String editarRuta(@PathVariable(value = "idRuta") Long id, Map<String, Object> model) {
        model.put("ruta", irutaService.findAll());

        Ruta ruta = null;
        if (id > 0) {
            ruta = irutaService.findOne(id);
            if (ruta == null) {
                return "redirect:/listaRutas";
            }
        } else {
            return "redirect:/listaRutas";
        }

        model.put("ruta", ruta);
        model.put("titulo", "Editar Ruta ");

        return "/addObject/addRuta";
    }


    //Guardar

    @PostMapping("/addRuta")
    public String crearRuta(@Validated Ruta ruta, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "/addObject/addRuta";
        }
        ruta.setEstado(true);
        irutaService.save(ruta);
        status.setComplete();
        return "redirect:/listaRutas";
    }

    //Delete ruta

    @RequestMapping("deleteRuta/{idRuta}")
    public String deleteRuta(@PathVariable(value = "idRuta") Long id, RedirectAttributes flash) {
        if (id > 0) {
            irutaService.remove(id);
            flash.addFlashAttribute("succes", "Ruta eliminada con exito");
        }

        return "redirect:/listaRutas";
    }

    //Eliminar con cambio de estado

    @RequestMapping(value = "deleteRutaId/{idRuta}")
    public String eliminarById(@PathVariable(value = "idRuta") Long id, RedirectAttributes flash) {

        if (id > 0) {
            irutaService.deleteByRutaId(id);
            flash.addFlashAttribute("success", "Ruta eliminada con éxito");
        }
        return "redirect:/listaRutas";
    }
}
