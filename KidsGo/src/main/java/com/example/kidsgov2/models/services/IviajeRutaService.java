package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.entities.Ruta;
import com.example.kidsgov2.entities.ViajeRuta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IviajeRutaService {
    public List<ViajeRuta> findAll();
    void save(ViajeRuta viajeRuta);
    List<Colegio> findByIdColegioRuta(Long id);
    List<Ruta> findByIdRutaColegio(Long id);


}
