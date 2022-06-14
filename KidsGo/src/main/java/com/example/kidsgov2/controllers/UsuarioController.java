package com.example.kidsgov2.controllers;

import com.example.kidsgov2.entities.Persona;
import com.example.kidsgov2.entities.Usuario;
import com.example.kidsgov2.models.dao.Ipersona;
import com.example.kidsgov2.models.dao.Iusuario;
import com.example.kidsgov2.models.services.IpersonaService;
import com.example.kidsgov2.models.services.IusuarioService;
import com.example.kidsgov2.models.services.JPAuserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

    @Autowired
    private IusuarioService iusuarioService;
    @Autowired
    private Iusuario iUsuarioDao;
    @Autowired
    private IpersonaService ipersonaService;


    @RequestMapping("/register/{id}")
    public String showRegistrationForm(@PathVariable(value = "id") Long id,Model model ) {
        Persona persona = ipersonaService.findOne(id);
        model.addAttribute( "user", new Usuario());
        model.addAttribute("idUser", id);
        model.addAttribute("personaId", persona);
        return "/addObject/registerUser";
    }

    @GetMapping("/process_register")
    public String processRegister(@Validated Usuario user, BindingResult result, Model model, SessionStatus status) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Ocurrio un error");
            return "/addObject/registerUser";
        }
        user.setEstado(true);
        iusuarioService.save(user);
        status.setComplete();
        return "redirect:/usersave/"+user.getIdUsuario();
    }


}
