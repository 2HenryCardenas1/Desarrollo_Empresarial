package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Ruta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IrutaService {
    public List<Ruta> findAll();

    public void save(Ruta ruta);

    public Ruta findOne(Long id);

    public void remove(Long idruta);

    void deleteByRutaId(Long id);



}
