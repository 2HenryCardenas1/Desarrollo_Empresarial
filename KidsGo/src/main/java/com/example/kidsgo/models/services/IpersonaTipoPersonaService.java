package com.example.kidsgo.models.services;


import com.example.kidsgo.entities.PersonaTipoPersona;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IpersonaTipoPersonaService {
    public List<PersonaTipoPersona> findAll();
}
