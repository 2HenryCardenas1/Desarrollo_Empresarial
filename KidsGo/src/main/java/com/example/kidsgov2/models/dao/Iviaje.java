package com.example.kidsgov2.models.dao;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import com.example.kidsgov2.entities.Viaje;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Iviaje extends CrudRepository<Viaje,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Viaje set estado = false where idViaje = ?1")
    public void deleteByViajeId(Long id);



}
