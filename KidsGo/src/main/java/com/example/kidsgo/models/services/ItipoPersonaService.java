package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.TipoPersona;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ItipoPersonaService {

    public List<TipoPersona> findAll();
}
