package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.EstadoSolictud;
import com.example.kidsgo.models.dao.IestadoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class EstadoSolicitudServiceImp implements IestadoSolicitudService{
    @Autowired
    private IestadoSolicitud estadoSolicitudDao;

    @Override
    @Transactional(readOnly = true)
    public List<EstadoSolictud> findAll() {
        return (List<EstadoSolictud>) estadoSolicitudDao.findAll();
    }
}
