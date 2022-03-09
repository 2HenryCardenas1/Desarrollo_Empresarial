package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IestadoSolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstadoSolicitudController {
    @Autowired
    private IestadoSolicitudService iestadoSolicitudService;


}
