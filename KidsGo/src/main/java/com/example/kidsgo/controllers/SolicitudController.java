package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IsolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SolicitudController {
    @Autowired
    private IsolicitudService isolicitudService;
}
