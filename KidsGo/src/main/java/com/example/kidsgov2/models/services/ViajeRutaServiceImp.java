package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import com.example.kidsgov2.entities.Ruta;
import com.example.kidsgov2.entities.ViajeRuta;
import com.example.kidsgov2.models.dao.IviajeRuta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ViajeRutaServiceImp implements IviajeRutaService{
    @Autowired
    //Llamamos a nuestra interfaz de colegio
    private IviajeRuta iviajeRuta;
    @Override
    //Indica que se hace movimiento de datos de lectura
    @Transactional(readOnly = true)
    //Metodo para traer los datos de la tabla colegio
    public List<ViajeRuta> findAll() {
        return (List<ViajeRuta>) iviajeRuta.findAll();
    }

    @Override
    public void save(ViajeRuta viajeRuta){
        iviajeRuta.save(viajeRuta);
    }

    @Override
    public List<Colegio> findByIdColegioRuta(Long id) {
        return (List<Colegio>) iviajeRuta.findByIdColegioRuta(id);
    }
    @Override
    public List<Ruta> findByIdRutaColegio(Long id) {
        return (List<Ruta>) iviajeRuta.findByIdRutaColegio(id);
    }
}
