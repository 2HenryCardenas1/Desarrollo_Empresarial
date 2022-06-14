package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.ColegioRuta;
import com.example.kidsgov2.models.dao.IcolegioRuta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ColegioRutaServiceImp implements IcolegioRutaService {
    //El autowired sirve para tener acceso a nuestra entidad
    @Autowired
    //Llamamos a nuestra interfaz de colegio
    private IcolegioRuta icolegioRutaDao;

    @Override
    //Indica que se hace movimiento de datos de lectura
    @Transactional(readOnly = true)
    //Metodo para traer los datos de la tabla colegio
    public List<ColegioRuta> findAll() {
        return (List<ColegioRuta>) icolegioRutaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ColegioRuta> findColegioRutaByDestino(){
        return  (List<ColegioRuta>) icolegioRutaDao.findColegioRutaByDestino();
    }

    @Override
    public void save(ColegioRuta colegioRuta){
        icolegioRutaDao.save(colegioRuta);
    }
}
