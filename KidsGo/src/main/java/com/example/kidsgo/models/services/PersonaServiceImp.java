package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Colegio;
import com.example.kidsgo.entities.Persona;
import com.example.kidsgo.models.dao.Ipersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class PersonaServiceImp implements IpersonaService{
    @Autowired
    private Ipersona personaDao;
    @Override
    @Transactional(readOnly = true)

    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Persona persona){
        personaDao.save(persona);
    }
}
