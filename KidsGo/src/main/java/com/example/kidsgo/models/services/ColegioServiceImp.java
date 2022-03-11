package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Colegio;
import com.example.kidsgo.models.dao.Icolegio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class ColegioServiceImp implements IcolegioService {
    //El autowired sirve para tener acceso a nuestra entidad
    @Autowired
    //Llamamos a nuestra interfaz de colegio
    private Icolegio colegioDao;


    @Override
    //Indica que se hace movimiento de datos de lectura
    @Transactional(readOnly = true)
    //Metodo para traer los datos de la tabla colegio
    public List<Colegio> findAll() {
        return (List<Colegio>) colegioDao.findAll();
    }

    @Override
    @Transactional
    public void save(Colegio colegio){
       colegioDao.save(colegio);
    }


    /*Buscar un colegio por id
    @Override
    @Transactional(readOnly = true)
    public Colegio findColegio(Long id){
        return colegioDao.findById(id).orElse(null);
    }*/
}
