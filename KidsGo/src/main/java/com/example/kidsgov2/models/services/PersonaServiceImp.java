package com.example.kidsgov2.models.services;

import com.example.kidsgov2.entities.Persona;
import com.example.kidsgov2.entities.TipoPersona;
import com.example.kidsgov2.entities.Usuario;
import com.example.kidsgov2.models.dao.Ipersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//Le indicamos que este archivo va a funcionar como un servicio
@Service
public class PersonaServiceImp implements IpersonaService{
    @Autowired
    private Ipersona personaDao;




    @Override
    @Transactional(readOnly = true)

    public List<Persona> findAll() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Persona persona){
        personaDao.save(persona);
    }

    //DELETE
    @Override
    @Transactional
    public void remove(Long id){
        personaDao.deleteById(id);
    }

    //Edit
    @Override
    @Transactional(readOnly = true)
    public Persona findOne(Long id){
        //Busque el id si no mande null
        return personaDao.findById(id).orElse(null);
    }

    //Estado
    @Override
    @Transactional
    public void deleteByPersonaId(Long id) {
        personaDao.deleteByPersonaId(id);
    }
}
