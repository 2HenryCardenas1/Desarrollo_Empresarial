package com.example.kidsgov2.models.dao;

import com.example.kidsgov2.entities.Vehiculo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface Ivehiculo extends CrudRepository<Vehiculo,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Vehiculo set estado = false where idVehiculo= ?1")
    public void deleteByVehiculoId(Long id);
}
