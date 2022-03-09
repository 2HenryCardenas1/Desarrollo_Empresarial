package com.example.kidsgo.models.services;


import com.example.kidsgo.entities.EstadoSolictud;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IestadoSolicitudService {
    public List<EstadoSolictud> findAll();
}
