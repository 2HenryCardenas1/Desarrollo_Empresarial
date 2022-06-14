package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IviajeService {
    public List<Viaje> findAll();
    public void save(Viaje viaje);

    public Viaje findOne(Long id);

    public void remove(Long id);

    void deleteByViajeId(Long id);

}
