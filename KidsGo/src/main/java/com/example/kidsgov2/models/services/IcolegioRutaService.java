package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.ColegioRuta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IcolegioRutaService {
    public List<ColegioRuta> findAll();
    List<ColegioRuta> findColegioRutaByDestino();
    void save(ColegioRuta colegioRuta);

}
