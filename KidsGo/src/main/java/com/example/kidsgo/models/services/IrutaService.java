package com.example.kidsgo.models.services;


import com.example.kidsgo.entities.Ruta;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IrutaService {
    public List<Ruta> findAll();
}
