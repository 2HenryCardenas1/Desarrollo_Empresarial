package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.PersonaVehiculo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IpersonaVehiculoService {
    public List<PersonaVehiculo> findAll();
}