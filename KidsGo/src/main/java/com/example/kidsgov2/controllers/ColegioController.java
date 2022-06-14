package com.example.kidsgov2.controllers;
import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.models.services.IcolegioService;
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
//Se nesecita el sessionAttributes para poder tener en memoria el objeto y poder guaradar en la bd
@SessionAttributes(names = "colegio")
public class ColegioController {
    @Autowired
    private IcolegioService icolegioService;


    //Ruta
    @GetMapping("/listarColegios")
    //El model llama los atributos que se quiera
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Colegios");
        model.addAttribute("colegios", icolegioService.findAll());
        return "/listObject/listarColegios";
    }

    //Crear
    //Obtenemos el get
    @GetMapping("/addColegios")
    public String agregarColegio(Model model) {
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("colegio", new Colegio());
        model.addAttribute("titulo", "Añadir un nuevo colegio");
        //Me manda al crearColegios
        return "/addObject/addColegios";
    }


    //Edit

    @RequestMapping(value = "/addColegios/{idColegio}")
    public String editarColegio(@PathVariable(value = "idColegio") Long id, Map<String, Object> model) {
        model.put("colegio", icolegioService.findAll());

        Colegio colegio = null;
        if (id > 0) {
            colegio = icolegioService.findOne(id);
            if (colegio == null) {
                return "redirect:/listarColegios";
            }
        } else {
            return "redirect:/listarColegios";
        }

        model.put("colegio", colegio);
        model.put("titulo", "Editar Colegio");
        return "/addObject/addColegios";

    }

    //Crear/GUARDAR

    @PostMapping("/addColegios")
    public String crearColegios(@Validated Colegio colegio, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo","Ocurrio un error");
            return "/addObject/addColegios";
        }
        colegio.setEstado(true);
        icolegioService.save(colegio);
        status.setComplete();
        //guardamos
        return "redirect:/listarColegios";
    }

    //DELETE


    @RequestMapping("deleteColegio/{idColegio}")
    public String deleteRuta(@PathVariable(value = "idColegio") Long id, RedirectAttributes flash) {
        if (id > 0) {
            icolegioService.remove(id);
            flash.addFlashAttribute("succes", "Colegio eliminado con exito");
        }

        return "redirect:/listarColegios";
    }


    //Eliminar con cambio de estado

    @RequestMapping(value = "deleteColegioId/{idColegio}")
    public String eliminarById(@PathVariable(value = "idColegio") Long id, RedirectAttributes flash) {

        if (id > 0) {
            icolegioService.deleteByColegioId(id);
            flash.addFlashAttribute("success", "Colegio eliminado con éxito");
        }
        return "redirect:/listarColegios";
    }


}
