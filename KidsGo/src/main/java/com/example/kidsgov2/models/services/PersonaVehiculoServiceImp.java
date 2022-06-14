package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.PersonaVehiculo;
import com.example.kidsgov2.models.dao.IpersonaVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaVehiculoServiceImp implements IpersonaVehiculoService{
    //El autowired sirve para tener acceso a nuestra entidad
    @Autowired
    //Llamamos a nuestra interfaz de colegio
    private IpersonaVehiculo ipersonaVehiculo;

    @Override
    //Indica que se hace movimiento de datos de lectura
    @Transactional(readOnly = true)
    //Metodo para traer los datos de la tabla colegio
    public List<PersonaVehiculo> findAll() {
        return (List<PersonaVehiculo>) ipersonaVehiculo.findAll();
    }
}
