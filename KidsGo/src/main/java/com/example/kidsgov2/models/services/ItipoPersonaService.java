package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import com.example.kidsgov2.entities.TipoPersona;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ItipoPersonaService {

    public List<TipoPersona> findAll();

}
