package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.Vehiculo;
import com.example.kidsgo.models.dao.Ivehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class VehiculoServiceImp implements IvehiculoService{
    @Autowired
    private Ivehiculo veiculoDao;
    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> findAll() {
        return (List<Vehiculo>) veiculoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Vehiculo vehiculo){
        veiculoDao.save(vehiculo);
    }

}
