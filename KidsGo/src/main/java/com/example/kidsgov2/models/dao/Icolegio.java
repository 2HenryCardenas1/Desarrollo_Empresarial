package com.example.kidsgov2.models.dao;


import com.example.kidsgov2.entities.Colegio;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface Icolegio extends CrudRepository<Colegio,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Colegio set estado = false where idColegio = ?1")
    public void deleteByColegioId(Long id);
}
