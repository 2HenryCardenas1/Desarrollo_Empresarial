package com.example.kidsgov2.models.dao;
import com.example.kidsgov2.entities.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IviajeRuta extends CrudRepository<ViajeRuta,Long> {

    @Query(value = "SELECT c FROM ViajeRuta vr INNER JOIN Ruta r ON r.idRuta= vr.fkRuta.idRuta INNER JOIN ColegioRuta cr ON cr.fkRuta.idRuta = r.idRuta INNER JOIN Colegio c ON c.idColegio = cr.fkColegio.idColegio WHERE vr.fkViaje.idViaje = ?1")
    public List<Colegio> findByIdColegioRuta(Long id);
    @Query(value = "SELECT r FROM ViajeRuta vr INNER JOIN Ruta r ON r.idRuta= vr.fkRuta.idRuta INNER JOIN ColegioRuta cr ON cr.fkRuta.idRuta = r.idRuta INNER JOIN Colegio c ON c.idColegio = cr.fkColegio.idColegio WHERE vr.fkViaje.idViaje = ?1")
    public List<Ruta> findByIdRutaColegio(Long id);
}
