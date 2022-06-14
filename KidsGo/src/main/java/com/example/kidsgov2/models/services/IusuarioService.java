package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.entities.Usuario;
import com.example.kidsgov2.entities.Viaje;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IusuarioService {
    public List<Usuario> findAll();
    public List<Viaje> getViajeById(Long id);
    void save(Usuario user);

}
