package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IpersonaService {
    public List<Persona> findAll();

    public void save(Persona persona);

    public void remove(Long id);

    public Persona findOne(Long id);

    void deleteByPersonaId(Long id);



}
