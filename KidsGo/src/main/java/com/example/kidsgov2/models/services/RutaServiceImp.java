package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Ruta;
import com.example.kidsgov2.models.dao.Iruta;
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

    //Traemos el id
    @Override
    @Transactional(readOnly = true)
    public Ruta findOne(Long id){
        //Busque el id si no mande null
        return rutaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
     public void remove(Long idruta){
        rutaDao.deleteById(idruta);
    }


    //Estado
    @Override
    @Transactional
    public void deleteByRutaId(Long id) {
        rutaDao.deleteByRutaId(id);
    }



}
