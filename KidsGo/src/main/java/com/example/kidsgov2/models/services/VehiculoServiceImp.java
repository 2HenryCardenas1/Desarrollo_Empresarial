package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Vehiculo;
import com.example.kidsgov2.models.dao.Ivehiculo;
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

    //Buscar por id
    @Override
    @Transactional(readOnly = true)
    public Vehiculo findOne(Long id){
        return veiculoDao.findById(id).orElse(null);
    }

    //remove
    @Override
    public void remove(Long idVehiculo){
        veiculoDao.deleteById(idVehiculo);
    }

    //Estado
    @Override
    @Transactional
    public void deleteByVehiculoId(Long id) {
        veiculoDao.deleteByVehiculoId(id);
    }

}
