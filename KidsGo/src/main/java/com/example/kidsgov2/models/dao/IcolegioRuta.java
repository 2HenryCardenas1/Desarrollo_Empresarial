package com.example.kidsgov2.models.dao;
import com.example.kidsgov2.entities.ColegioRuta;
import com.example.kidsgov2.entities.PersonaTipoPersona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IcolegioRuta extends CrudRepository<ColegioRuta,Long> {
    @Query(value = "SELECT cr FROM ColegioRuta cr INNER JOIN Colegio c ON c.idColegio=cr.fkColegio.idColegio INNER JOIN Ruta r ON r.idRuta = cr.fkRuta.idRuta")
    public List<ColegioRuta> findColegioRutaByDestino();
}
