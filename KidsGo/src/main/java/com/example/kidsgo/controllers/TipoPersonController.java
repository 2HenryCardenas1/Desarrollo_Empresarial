package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.ItipoPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TipoPersonController {
    @Autowired
    private ItipoPersonaService itipoPersonaService;
}
