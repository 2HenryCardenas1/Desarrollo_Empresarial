package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Ruta;
import com.example.kidsgo.models.dao.Iruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class RutaServiceImp implements IrutaService {
    @Autowired
    private Iruta rutaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ruta> findAll() {
        return (List<Ruta>) rutaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Ruta ruta){
        rutaDao.save(ruta);
    }
}
