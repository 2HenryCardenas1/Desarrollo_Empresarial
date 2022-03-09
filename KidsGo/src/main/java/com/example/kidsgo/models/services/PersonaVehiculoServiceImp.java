package com.example.kidsgo.models.services;

import com.example.kidsgo.entities.PersonaVehiculo;
import com.example.kidsgo.models.dao.IpersonaVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class PersonaVehiculoServiceImp implements IpersonaVehiculoService{
    @Autowired
    private IpersonaVehiculo personaVehiculoDao;
    @Override
    @Transactional(readOnly = true)
    public List<PersonaVehiculo> findAll() {
        return (List<PersonaVehiculo>) personaVehiculoDao.findAll();
    }
}
