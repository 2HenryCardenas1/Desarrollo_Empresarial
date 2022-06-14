package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IvehiculoService {
    public List<Vehiculo> findAll();
    public void save(Vehiculo vehiculo);
    public Vehiculo findOne(Long id);

    public void remove(Long id);

    void deleteByVehiculoId(Long id);
}
