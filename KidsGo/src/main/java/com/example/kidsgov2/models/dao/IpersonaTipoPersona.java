package com.example.kidsgov2.models.dao;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IpersonaTipoPersona extends CrudRepository<PersonaTipoPersona, Long> {

    @Query(value = "SELECT ptp FROM PersonaTipoPersona ptp INNER JOIN Persona p ON p.idPersona = ptp.FKpersona.idPersona INNER JOIN TipoPersona tp ON tp.idTipoPersona = ptp.FKtipoPersona.idTipoPersona WHERE p.idPersona = ?1")
    List<PersonaTipoPersona> findByIdTipoPersona(Long id);

    //Query para traer solo los conductores
    @Query(value = "SELECT ptp FROM PersonaTipoPersona ptp INNER JOIN Persona p ON p.idPersona = ptp.FKpersona.idPersona INNER JOIN TipoPersona tp ON tp.idTipoPersona = ptp.FKtipoPersona.idTipoPersona WHERE ptp.FKtipoPersona.idTipoPersona = 1")
    List<PersonaTipoPersona> findByTipoPersonaConductor();
}

