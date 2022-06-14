package com.example.kidsgov2.models.services;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import com.example.kidsgov2.models.dao.IpersonaTipoPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaTpServiceImp implements IpersonaTipoPersonaService {
    @Autowired
    private IpersonaTipoPersona ipersonaTipoPersona;
    @Override
    @Transactional(readOnly = true)

    public List<PersonaTipoPersona> findAll() {
        return (List<PersonaTipoPersona>) ipersonaTipoPersona.findAll();
    }

    @Override
    @Transactional
    public void save(PersonaTipoPersona personaTipoPersona){
        ipersonaTipoPersona.save(personaTipoPersona);
    }

    @Override
    public List<PersonaTipoPersona> findByIdTipoPersona(Long id) {
        return (List<PersonaTipoPersona>) ipersonaTipoPersona.findByIdTipoPersona(id);
    }

    @Override
    public List<PersonaTipoPersona> findByTipoPersonaConductor() {
        return (List<PersonaTipoPersona>) ipersonaTipoPersona.findByTipoPersonaConductor();
    }

}
