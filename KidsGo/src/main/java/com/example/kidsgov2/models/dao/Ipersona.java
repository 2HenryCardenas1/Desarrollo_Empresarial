package com.example.kidsgov2.models.dao;
import com.example.kidsgov2.entities.Persona;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


public interface Ipersona extends CrudRepository<Persona, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Persona set estado = false where idPersona = ?1")
    public void deleteByPersonaId(Long id);
}
