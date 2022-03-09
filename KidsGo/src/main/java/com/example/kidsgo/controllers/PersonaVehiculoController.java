package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IpersonaVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PersonaVehiculoController {
    @Autowired
    private IpersonaVehiculoService ipersonaVehiculoService;
}
