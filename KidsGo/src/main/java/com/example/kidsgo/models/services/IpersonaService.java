package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Colegio;
import com.example.kidsgo.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IpersonaService {
    public List<Persona> findAll();

    public void save(Persona persona);

}
