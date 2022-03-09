package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.PersonaTipoPersona;
import com.example.kidsgo.models.dao.IpersonaTipoPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class PersonaTipoPersonaServiceImp implements IpersonaTipoPersonaService {
    @Autowired
    private IpersonaTipoPersona personaHasTipoPersonaDao;


    @Override
    @Transactional(readOnly = true)
    public List<PersonaTipoPersona> findAll() {
        return (List<PersonaTipoPersona>) personaHasTipoPersonaDao.findAll();
    }
}
