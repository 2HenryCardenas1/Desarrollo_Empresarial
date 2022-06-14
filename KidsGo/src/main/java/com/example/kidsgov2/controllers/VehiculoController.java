package com.example.kidsgov2.controllers;
import com.example.kidsgov2.entities.Vehiculo;
import com.example.kidsgov2.models.services.IvehiculoService;
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
@SessionAttributes("vehiculo")
public class VehiculoController {
    @Autowired
    private IvehiculoService ivehiculoService;

    @GetMapping("/listaVehiculos")
    public String listarVehiculos(Model model) {
        model.addAttribute("titulo", "Listado de vehiculos registrados");
        model.addAttribute("vehiculo", ivehiculoService.findAll());
        return "/listObject/listadoVehiculos";
    }

    //Crear
    @GetMapping("/addVehiculo")
    public String agregarVehiculo(Model model) {
        model.addAttribute("titulo", "Agregar Vehiculo");
        model.addAttribute("vehiculo", new Vehiculo());

        return "/addObject/addVehiculo";

    }

    //Editar

    @RequestMapping("/addVehiculo/{idVehiculo}")
    public String editarVehiculo(@PathVariable("idVehiculo") Long id, Map<String, Object> model) {
        //Traigo toda la data para despues buscar por id
        model.put("vehiculo", ivehiculoService.findAll());
        Vehiculo vehiculo = null;
        if (id > 0) {
            //asiganmos el id
            vehiculo = ivehiculoService.findOne(id);
            if (vehiculo == null) {
                return "redirect:/listaVehiculos";
            }
        } else {
            return "redirect:/listaVehiculos";
        }

        model.put("vehiculo", vehiculo);
        model.put("titulo", "Editar Vehiculo");

        return "/addObject/addVehiculo";
    }


    //Guardar

    @PostMapping("addVehiculo")
    public String guardarVehiculo(@Validated Vehiculo vehiculo, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "/addObject/addVehiculo";
        }
        vehiculo.setEstado(true);
        ivehiculoService.save(vehiculo);
        status.setComplete();
        return "redirect:/listaVehiculos";
    }

    //Eliminar

    @RequestMapping("deleteVehiculo/{idVehiculo}")
    public String deleteVehiculo(@PathVariable("idVehiculo") Long id, RedirectAttributes flash){
        if (id > 0){
            ivehiculoService.remove(id);
            flash.addFlashAttribute("success","Vehiculo eliminado");
        }
        return "redirect:/listaVehiculos";
    }

    //Eliminar con cambio de estado

    @RequestMapping(value = "deleteVehiculoId/{idVehiculo}")
    public String eliminarById(@PathVariable(value = "idVehiculo") Long id, RedirectAttributes flash) {

        if (id > 0) {
            ivehiculoService.deleteByVehiculoId(id);
            flash.addFlashAttribute("success", "Vehiculo eliminado con éxito");
        }
        return "redirect:/listaVehiculos";
    }

}
