package com.example.kidsgo.models.dao;

import com.example.kidsgo.entities.PersonaTipoPersona;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IpersonaTipoPersona extends CrudRepository<PersonaTipoPersona, Long> {
    @Transactional
    @Modifying
    @Query("SELECT tp.tipoPersona FROM PersonaTipoPersona ptp INNER JOIN Persona p ON p.idPersona = ptp.fkPersona INNER JOIN TipoPersona tp ON tp.idTipoPersona = ptp.fkTipoPersona")
    public String listarTipoPersona();
}
