package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Solicitud;
import com.example.kidsgo.models.dao.Isolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class SolicitudServiceImp implements IsolicitudService{
    @Autowired
    private Isolicitud solicitudDao;
    @Override
    @Transactional(readOnly = true)
    public List<Solicitud> findAll() {
        return (List<Solicitud>) solicitudDao.findAll();
    }
}
