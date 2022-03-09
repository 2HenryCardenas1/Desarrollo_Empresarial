package com.example.kidsgo.models.services;


import com.example.kidsgo.entities.Solicitud;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IsolicitudService {
    public List<Solicitud> findAll();
}
