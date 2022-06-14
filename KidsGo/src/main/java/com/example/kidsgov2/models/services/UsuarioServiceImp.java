package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.entities.Usuario;
import com.example.kidsgov2.entities.Viaje;
import com.example.kidsgov2.models.dao.Iusuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements IusuarioService {
    @Autowired
    private Iusuario iusuario;

    @Override
    //Indica que se hace movimiento de datos de lectura
    @Transactional(readOnly = true)
    //Metodo para traer los datos de la tabla colegio
    public List<Usuario> findAll() {
        return (List<Usuario>) iusuario.findAll();
    }


    @Override
    public List<Viaje> getViajeById(Long id) {
        return (List<Viaje>) iusuario.getViajeById(id);
    }


    @Override
    @Transactional
    public void save(Usuario user){
        iusuario.save(user);
    }


}
