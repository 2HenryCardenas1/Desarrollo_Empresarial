package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IviajeService {
    public List<Viaje> findAll();
}
