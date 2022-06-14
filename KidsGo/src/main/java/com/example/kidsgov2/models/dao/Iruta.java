package com.example.kidsgov2.models.dao;

import com.example.kidsgov2.entities.Ruta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface Iruta extends CrudRepository<Ruta,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Ruta set estado = false where idRuta = ?1")
    public void deleteByRutaId(Long id);


}
