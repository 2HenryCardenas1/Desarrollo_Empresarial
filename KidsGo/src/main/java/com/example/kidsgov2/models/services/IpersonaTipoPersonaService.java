package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IpersonaTipoPersonaService {
    List<PersonaTipoPersona> findAll();
    void save(PersonaTipoPersona personaTipoPersona);
    List<PersonaTipoPersona> findByIdTipoPersona(Long id );
    List<PersonaTipoPersona> findByTipoPersonaConductor();
}
