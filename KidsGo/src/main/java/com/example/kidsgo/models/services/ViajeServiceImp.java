package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Viaje;
import com.example.kidsgo.models.dao.Iviaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class ViajeServiceImp implements IviajeService{
    @Autowired
    private Iviaje viajeDao;
    @Override
    @Transactional(readOnly = true)
    public List<Viaje> findAll() {
        return (List<Viaje>) viajeDao.findAll();
    }
}
