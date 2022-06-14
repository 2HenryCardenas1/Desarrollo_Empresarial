package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Viaje;
import com.example.kidsgov2.models.dao.Iviaje;
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

    @Override
    @Transactional
    public void save(Viaje viaje){
        viajeDao.save(viaje);
    }

    @Override
    @Transactional(readOnly = true)
    public Viaje findOne(Long id){
        //Busque el id si no mande null
        return viajeDao.findById(id).orElse(null);
    }

    @Override
    public void remove(Long idViaje){
        viajeDao.deleteById(idViaje);
    }


    //Eliminar por id
    public void deleteByViajeId(Long id){
        viajeDao.deleteByViajeId(id);
    }
}
