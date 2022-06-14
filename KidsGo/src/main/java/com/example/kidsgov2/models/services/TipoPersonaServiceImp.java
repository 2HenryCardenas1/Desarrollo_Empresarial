package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.PersonaTipoPersona;
import com.example.kidsgov2.entities.TipoPersona;
import com.example.kidsgov2.models.dao.ItipoPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class TipoPersonaServiceImp implements ItipoPersonaService{
    @Autowired
    private ItipoPersona tipoPersonaDao;
    @Override
    public List<TipoPersona> findAll() {
        return (List<TipoPersona>) tipoPersonaDao.findAll();
    }

}
