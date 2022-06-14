package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Authority;
import com.example.kidsgov2.entities.Colegio;
import com.example.kidsgov2.models.dao.Iauthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorityServiceImp implements IauthorityService{
    @Autowired
    private Iauthority iauthority;

    @Override
    //Indica que se hace movimiento de datos de lectura
    @Transactional(readOnly = true)
    //Metodo para traer los datos de la tabla colegio
    public List<Authority> findAll() {
        return (List<Authority>) iauthority.findAll();
    }


    @Override
    @Transactional
    public void save(Authority authority){
        iauthority.save(authority);
    }
}
