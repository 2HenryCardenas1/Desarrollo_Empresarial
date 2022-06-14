package com.example.kidsgov2.controllers;

import com.example.kidsgov2.entities.Authority;
import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.entities.Usuario;
import com.example.kidsgov2.models.services.IauthorityService;
import com.example.kidsgov2.models.services.JPAuserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("authority")
public class AuthorityController {

    @Autowired
    private IauthorityService iauthorityService;

    //Crear
    //Obtenemos el get
    @RequestMapping("/usersave/{id}")
    public String agregarAuthority(@PathVariable(value = "id") Long id, Model model) {
        //Instanciamos un nuevo objeto de Colegio
        model.addAttribute("rol", new Authority());
        model.addAttribute("iduser",id);
        //Me manda al crearColegios
        return "/default/register_succes";
    }

    private Logger logger = LoggerFactory.getLogger(JPAuserDetailService.class);

    @GetMapping("/save")
    public String saveAuthority(@Validated Authority authority, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Ocurrio un error");
            return "/default/register_succes";
        }
        authority.setRolUser("ROLE_USER");
        iauthorityService.save(authority);
        status.setComplete();
        logger.info("Este es el rol: " + authority.getRolUser());
        //guardamos
        return "redirect:/login";
    }
}
