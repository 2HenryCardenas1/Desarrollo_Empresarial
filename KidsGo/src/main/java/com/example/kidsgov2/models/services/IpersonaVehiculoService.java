package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.PersonaVehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IpersonaVehiculoService {
    public List<PersonaVehiculo> findAll();
}
