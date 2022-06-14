package com.example.kidsgov2.controllers;
import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.entities.Viaje;
import com.example.kidsgov2.models.dao.IcolegioRuta;
import com.example.kidsgov2.models.dao.IviajeRuta;
import com.example.kidsgov2.models.services.*;
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
@SessionAttributes("viaje")
public class ViajeController {
    @Autowired
    private IviajeService iviajeService;
    @Autowired
    private IpersonaTipoPersonaService ipersonaTipoPersonaService;
    @Autowired
    private IviajeRutaService iviajeRutaService;
    @Autowired
    private IrutaService irutaService;

    @Autowired
    private JPAuserDetailService jpAuserDetailService;

    //Ruta
    @GetMapping("/listarViajes")
    //El model llama los atributos que se quiera
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Viajes");
        model.addAttribute("viaje", iviajeService.findAll());
        return "/listObject/listarViajes";
    }

    //Crear
    //Obtenemos el get
    @GetMapping("/addViaje")
    public String agregarViaje(Model model) {
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("viaje", new Viaje());
        model.addAttribute("titulo", "Añadir un nuevo viaje");
        model.addAttribute("tipopersona",ipersonaTipoPersonaService.findByTipoPersonaConductor());
        //Me manda al crearColegios

        return "/addObject/addViaje";
    }

    //Crear
    //Obtenemos el get
    @RequestMapping("/addViajeByUser/{idPesona}")
    public String agregarViajeById(@PathVariable(value = "idPesona") Long id,Model model) {
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("viaje", new Viaje());
        model.addAttribute("idPersona",id);
        model.addAttribute("titulo", "Añadir un nuevo viaje");
        model.addAttribute("tipopersona",ipersonaTipoPersonaService.findByTipoPersonaConductor());
        //Me manda al crearColegios

        return "/addObject/addViaje";
    }

    //Edit
    @RequestMapping(value = "/addViaje/{idViaje}")
    public String editarViaje(@PathVariable(value = "idViaje") Long id, Map<String, Object> model) {
        model.put("viaje", iviajeService.findAll());
        model.put("viajeId",id);
        model.put("tipopersona",ipersonaTipoPersonaService.findByTipoPersonaConductor());

        Viaje viaje = null;
        if (id > 0) {
            viaje = iviajeService.findOne(id);
            if (viaje == null) {
                return "redirect:/listarViajes";
            }
        } else {
            return "redirect:/listarViajes";
        }

        model.put("viaje", viaje);
        model.put("titulo", "Editar Viaje");
        return "/addObject/addViaje";

    }

    //Crear/GUARDAR

    @PostMapping("/addViaje")
    public String crearViaje(@Validated Viaje viaje, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo","Ocurrio un error");
            model.addAttribute("error",result.getAllErrors());
            return "/addObject/addViaje";
        }
        viaje.setEstado(true);

        iviajeService.save(viaje);
        status.setComplete();
        //guardamos
        return "redirect:/listarViajes";
    }

     //DELETE

    //Delete ruta

    @RequestMapping("deleteViaje/{idViaje}")
    public String deleteRuta(@PathVariable(value = "idViaje") Long id, RedirectAttributes flash) {
        if (id > 0) {
            iviajeService.remove(id);
            flash.addFlashAttribute("succes", "Viaje eliminado con exito");
        }

        return "redirect:/listarViajes";
    }

    //Eliminar con cambio de estado

    @RequestMapping(value = "deleteViajeId/{idViaje}")
    public String eliminarById(@PathVariable(value = "idViaje") Long id, RedirectAttributes flash) {

        if (id > 0) {
            iviajeService.deleteByViajeId(id);
            flash.addFlashAttribute("success", "Viaje eliminado con éxito");
        }
        return "redirect:/listarViajes";
    }

    //Colegio-Ruta (Traer coelgio destino)

    //Detalle viaje

    @RequestMapping("/details/detailViaje/{id}")
    public String detallesViaje(@PathVariable(value = "id") Long id, Map<String,Object> model){
        model.put("titulo","Detalles del viaje");
        model.put("viaje", iviajeService.findOne(id));
        model.put("colegio",iviajeRutaService.findByIdColegioRuta(id));
        model.put("ruta",iviajeRutaService.findByIdRutaColegio(id));
        return "/details/detailViaje";
    }




    //Usuario - Viaje (trar info viaje por id de usuario)
    //Ruta
    @RequestMapping("/listarViajesByUser/{id}")
    //El model llama los atributos que se quiera
    public String getViajeById(@PathVariable(value = "id") Long id, Map<String,Object> model) {
        model.put("titulo", "Listado de Viajes");
        model.put("viaje",iviajeService.findOne(id));
        return "/listObject/listarViajesByUser";
    }

}
