package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IpersonaTipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonaTipoPersonaController {
    @Autowired
    private IpersonaTipoPersonaService ipersonaTipoPersonaService;
}
