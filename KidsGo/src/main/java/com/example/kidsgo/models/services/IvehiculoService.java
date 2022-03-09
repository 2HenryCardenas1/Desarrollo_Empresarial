package com.example.kidsgo.models.services;


import com.example.kidsgo.entities.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IvehiculoService {
    public List<Vehiculo> findAll();
}
