package com.example.kidsgo.controllers;

import com.example.kidsgo.models.services.IviajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ViajeController {
    @Autowired
    private IviajeService iviajeService;
}
